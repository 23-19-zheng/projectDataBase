package com.zheng.util;

import com.zheng.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@Component
public class HtmlParseUtil {
//    public static void main(String[] args) throws Exception {
//        //测试
//        new HtmlParseUtil().parseJD("java").forEach(System.out::println);
//    }
    public List<Content> parseJD(String keywords) throws Exception {
        //请求路径
        String url = "https://search.jd.com/Search?keyword="+keywords;
        //返回的就是js网页，一个完整的前端界面
        Document document = Jsoup.parse(new URL(url), 10000);

        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        ArrayList<Content> list = new ArrayList<>();
        //遍历整理li列表中的所有元素
        for (Element el:elements) {
            //对于图片多的网页，使用的是延迟加载，一般都使用懒加载
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImages(img);
            content.setPrice(price);
            content.setTitle(title);
            list.add(content);
        }
        return list;
    }
}
