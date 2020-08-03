package com.lwjzt.lzcore.elasticsearch;

import cn.hutool.json.JSONObject;
import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.Map;

public class ElasticSearchDemo {

    static private RestHighLevelClient client;

    public static RestHighLevelClient getES() {
        if (client == null) {
            client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("10.147.17.123", 9200, "http")));
        }
        return client;
    }

    public void searchRequest() throws IOException {
//        1.创建请求
        SearchRequest searchRequest = new SearchRequest();
//        设置索引
        searchRequest.indices("bank");
//        构建条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "Street"));
        System.out.println(searchSourceBuilder);
        searchRequest.source(searchSourceBuilder);
//        发送请求
        SearchResponse search = getES().search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search);
    }

    public void searchRequestComplex() throws IOException {

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery("age", 33));
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = getES().search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = search.getHits();
        TotalHits totalHits = hits.getTotalHits();
        long value = totalHits.value;
        TotalHits.Relation relation = totalHits.relation;

        SearchHit[] record = hits.getHits();
        for (SearchHit sea :
                record) {
            sea.getIndex();
            sea.getType();
            sea.getId();
            Map<String, Object> sourceAsMap = sea.getSourceAsMap();
            System.out.println("===");
        }
        JSONObject jsonObject = new JSONObject(search);
        System.out.println(jsonObject);
    }

    public static void main(String[] args) throws IOException {
        new ElasticSearchDemo().searchRequest();
        new ElasticSearchDemo().searchRequestComplex();
    }

}
