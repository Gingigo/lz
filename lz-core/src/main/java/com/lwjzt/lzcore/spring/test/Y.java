package com.lwjzt.lzcore.spring.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2020-09-12 20:04:39
 */
@Component
@Scope("singleton")
public class Y {

    public Y(){
        System.out.println("CREATE Y");
    }
}
