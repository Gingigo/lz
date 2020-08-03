package com.lwjzt.lzcore.elasticsearch;

import com.lwjzt.lzcore.domain.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import com.alibaba.fastjson.JSON;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ElasticSearchDemoTest {

    @Test
    void getES() throws IOException {
        RestHighLevelClient es = ElasticSearchDemo.getES();
        IndexRequest request = new IndexRequest("users");
        request.id("1");
        User user = new User();
        user.setAge(10);
        user.setUserName("lee");
        String jsonString = JSON.toJSONString(user);
        request.source(jsonString, XContentType.JSON);
        IndexResponse index = es.index(request, RequestOptions.DEFAULT);
        System.out.println(index);
        es.close();
    }
}