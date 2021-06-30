package com.leexiaobu.springcloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Leexiaobu
 * @date 2020-11-03 11:13:09
 */

@FeignClient(name = "eureka-client" ,fallback = Fallback.class)
public interface MyService  {
    @GetMapping("/sayHi")
    String sayHi();

    @GetMapping("/retry")
    public String retry(@RequestParam(name = "timeout") Integer timeout);

    @GetMapping("/error")
    public String error();

    @PostMapping("/sayHi")
    public Friend sayHiPost(@RequestBody Friend friend);



}
