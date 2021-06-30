package cn.leexiaobu.service;

import java.util.concurrent.CompletableFuture;

/**
 * 基于CompletableFuture的异步执行
 * @author Leexiaobu
 * @date 2021-02-24 22:31
 */
public interface GreetingServiceAsync {
  CompletableFuture<String> sayHello(String name);
}