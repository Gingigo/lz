package com.leexiaobu.eurekaclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author oujia
 */
@RestController
@Slf4j
public class Controller {

    @Value("${server.port}")
    private String port;

    @GetMapping("/sayHi")
    public String sayHi() {
        return "This is " + port;
    }

    @PostMapping("/sayHi")
    public Friend sayHiPost(@RequestBody Friend friend) {
        log.info("You are " + friend.getName());
        friend.setPort(port);
        return friend;
    }

    @GetMapping("/retry")
    public String retry(Integer timeout) {
        while (--timeout >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        log.info("retry" + port);
        return "This retry is " + port;
    }

    @GetMapping("/error")
    public String error() {
        throw new RuntimeException("black sheep");
    }



}
