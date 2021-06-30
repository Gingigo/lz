package com.leexiaobu.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2020-11-03 11:13:57
 */
@Component
@Slf4j
public class Fallback  implements MyService{

    @Override
    @HystrixCommand(fallbackMethod ="fallback1" )
    public String error() {
        log.info("Fall back: 第0次降级");
        throw new RuntimeException("fall back");
    }
    @HystrixCommand(fallbackMethod ="fallback2" )
    public String fallback1() {
        log.info("Fall back: 第一次降级");
        throw new RuntimeException("fall back again 1");
    }

    @HystrixCommand(fallbackMethod ="fallback3" )
    public String fallback2() {
        log.info("Fall back: 第2次降级");
        throw new RuntimeException("fall back again 2");
    }

    public String fallback3() {
        log.info("Fall back: 第3次降级");
        return "Fall back: conusmer not a black sheep any more";
    }
    @Override
    public Friend sayHiPost(Friend friend) {
        return null;
    }

    @Override
    public String sayHi() {
        return null;
    }

    @Override
    public String retry(Integer timeout) {
        return "You are late !";
    }


}
