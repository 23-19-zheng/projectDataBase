package com.zheng.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.zheng.entity.Content;
import com.zheng.service.ContentService;
import com.zheng.util.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public boolean parseContent(String keywords) throws Exception {
        List<Content> contents = new HtmlParseUtil().parseJD(keywords);//解析网页并得到js界面
        BulkRequest bulkRequest = new BulkRequest();//批量插入请求
        bulkRequest.timeout("2m");//设置超时的时间
        for (int i = 0; i < contents.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_index") //创建索引
            .source(JSON.toJSONString(contents.get(i)), XContentType.JSON));//数据的源
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);//ES高级客户端发起请求
        boolean b = bulk.hasFailures();//判断请求是否失败
        return !b;
    }

    @Override
    public List<Map<String, Object>> searchPage(String keywords, int pageNo, int pageSize) throws IOException {
        if(pageNo <=1 ){
            pageNo = 1;
        }
        //创建索引请求和绑定索引库
        SearchRequest searchRequest = new SearchRequest("jd_index");
        //构建查询的条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页
        searchSourceBuilder.from(pageNo);//从哪里开始
        searchSourceBuilder.size(pageSize);//每一页有多大
        // 创建条件
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keywords);
        //将条件放入够放进的查询条件里面
        searchSourceBuilder.query(termQueryBuilder);
        //超时设置
        searchSourceBuilder.timeout(new TimeValue(60,TimeUnit.SECONDS));
        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);//把多个高亮的值关闭，只高亮第一个出现的值
        highlightBuilder.preTags("<span style='color:red'>");//高亮字段的前缀
        highlightBuilder.postTags("</span>");//高亮字段的后缀
        searchSourceBuilder.highlighter(highlightBuilder);//将高亮条件放入够放进的查询条件里面
        //客户端执行请求
        searchRequest.source(searchSourceBuilder);//搜索的条件放到总的一个搜索里面
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //创建一个list集合
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        //遍历出搜索的所有对象
        for (SearchHit documentFields:searchResponse.getHits().getHits()) { //option + enter自动导包
            Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();//获取高亮的map对象，Map集合映射的字段
            HighlightField title = highlightFields.get("title");//取出高亮的真实值
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();//原来的结果
            if(title != null){
                Text[] fragments = title.fragments();//取出所有的title放入到text类型的数组中
                String n_title = "";
                for (Text text:fragments) {
                    n_title += text;//赋值操作
                }
                sourceAsMap.put("title",n_title);//替换原来的值
            }
            lists.add(documentFields.getSourceAsMap());
        }
        System.out.println(lists.size());
        return lists;
    }
}
