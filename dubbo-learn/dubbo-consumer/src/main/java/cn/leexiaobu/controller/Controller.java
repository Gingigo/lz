package cn.leexiaobu.controller;

import cn.leexiaobu.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leexiaobu
 * @date 2021-03-10 14:28
 */
@RestController
public class Controller {

  @Autowired
  AgentService agentService;

  @GetMapping("/hello")
  public String hello(String name) {
    System.out.println(name);

    return agentService.sayHello(name);
  }


}