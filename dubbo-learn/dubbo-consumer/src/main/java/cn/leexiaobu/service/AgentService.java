package cn.leexiaobu.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author Leexiaobu
 * @date 2021-02-25 10:03
 */
@Service
public class AgentService {

  @DubboReference
  GreetingService greetingService;


  public String sayHello(String name) {
    return greetingService.sayHello(name);
  }
}