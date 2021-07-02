package com.zheng.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EsHighClientConfig {
    @Bean
    //spring有一个Beans文件
    //<beans id = "方法名" class = "返回值类型">
    public RestHighLevelClient restHighLevelClient(){
        //构建一个高级的客户端
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));
        return client;
    }
}
