package com.leexiaobu.springcloud;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 半仙.
 */

@RestController
@Slf4j
@Component
public class Controller {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        /*1.Eureka 调用方法*/
        ServiceInstance instance = client.choose("eureka-client");
        if (instance == null) {
            return "No available instances";
        }
        String target = String.format("http://%s:%s/sayHi",
                instance.getHost(),
                instance.getPort());
        log.info("url is {}", target);
        return restTemplate.getForObject(target, String.class);
    }

    @PostMapping("/hello")
    public Friend helloPost() {
        ServiceInstance instance = client.choose("eureka-client");

        if (instance == null) {
            return null;
        }

        String target = String.format("http://%s:%s/sayHi",
                instance.getHost(),
                instance.getPort());
        log.info("url is {}", target);

        Friend friend = new Friend();
        friend.setName("Eureka Consumer");

        return restTemplate.postForObject(target, friend, Friend.class);
    }

    @GetMapping("/helloRibbon")
    public String helloRibbon() {
        /*2.Ribbon调用方法
         * 通过@LoadBalance 注解 设置成负载均衡*/

        return restTemplate.getForObject(
                "http://eureka-client/sayHi",
                String.class);
    }

    @Autowired
//     开启Hystrix后
    IService iService;

    /*feign远程调用*/
    @GetMapping("/feignHello")
    public String feign() {
        return iService.sayHi();
    }

    @GetMapping("/feignRetry")
    public String retry(Integer timeout) {

        return iService.retry(timeout);
    }

    @Autowired
    MyService myService;

    @GetMapping("/fallback")
    public String error() {
        return myService.error();
    }

    @GetMapping("/timeout")
    public String timeout(Integer timeout) {
        return myService.retry(timeout);
    }

    @Autowired
    RequestCacheService requestCacheService;

    @GetMapping("/cache")
    public Friend timeout(String name) {
        @Cleanup HystrixRequestContext hystrixRequestContext = HystrixRequestContext.initializeContext();
        Friend friend = requestCacheService.requestCache(name);

        friend = requestCacheService.requestCache(name);
        return friend;
    }


    @Value("${name}")
    private String name;

    @Value("${myWords}")
    private String words;

    @GetMapping("/name")
    public String getName() {
        return name;
    }

    @GetMapping("/words")
    public String getWords() {
        return words;
    }
}
