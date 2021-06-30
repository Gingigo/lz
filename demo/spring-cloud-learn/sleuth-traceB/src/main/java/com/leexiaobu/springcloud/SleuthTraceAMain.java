package com.leexiaobu.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leexiaobu
 * @date 2020-11-04 20:47:46
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Slf4j
public class SleuthTraceAMain {
    @Bean
    @LoadBalanced
    public RestTemplate lb() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        new SpringApplicationBuilder(SleuthTraceAMain.class).web(WebApplicationType.SERVLET).run(args);
    }

    @GetMapping(value = "/traceB")
    public String traceB() {
        log.info("-------Trace B");
        return "traceB";
    }
}
