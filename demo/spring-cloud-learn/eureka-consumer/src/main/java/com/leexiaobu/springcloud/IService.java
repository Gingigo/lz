package com.leexiaobu.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Leexiaobu
 * @date 2020-11-03 9:44:07
 */
@FeignClient("eureka-client")
public interface IService {
    @GetMapping("/sayHi")
    String sayHi();

    @GetMapping("/retry")
    public String retry(@RequestParam(name = "timeout") Integer timeout);

    @GetMapping("/error")
    public String error();
}
