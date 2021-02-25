package com.lwjzt.lzcore.config;

import com.alibaba.fastjson.JSON;
import com.lwjzt.lzcore.domain.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Leexiaobu
 * @date 2020-10-11 15:24:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class ElasticSearchConfigTest {
    @Autowired
    private RestHighLevelClient client;

    @Test
    public void contexttest() {
        System.out.println(client);
    }

    @Test
    public void indexTest() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
//        indexRequest.source("users");
        indexRequest.id("100");
        User user = new User();
        user.setUserName("lwjjjj");
        String json = JSON.toJSONString(user);
        indexRequest.source(json, XContentType.JSON);
        IndexResponse index = client.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Test
    public void complexSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("bank");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        TermsAggregationBuilder age = AggregationBuilders.terms("ageAgg").field("age").size(10);
        searchSourceBuilder.aggregation(age);
        AvgAggregationBuilder size = AggregationBuilders.avg("balance").field("balance");
        searchSourceBuilder.aggregation(size);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(search);
        SearchHits hits = search.getHits();
        SearchHit[] hits1 = hits.getHits();
    }

}