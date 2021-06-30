package cn.leexiaobu.service;

/**
 * 基于AsyncContext异步执行
 * @author Leexiaobu
 * @date 2021-02-24 22:33
 */
public interface GreetingServiceRpcContext {
    String sayHello(String name);
}
