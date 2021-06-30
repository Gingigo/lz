package cn.leexiaobu.service;

import cn.leexiaobu.pojo.PoJo;
import cn.leexiaobu.pojo.Result;

/**
 * 演示同步执行
 * @author Leexiaobu
 * @date 2021-02-24 22:27
 */
public interface GreetingService {
   String sayHello(String name);
  Result<String> testGeneric(PoJo poJo);
}