package cn.leexiaobu.controller;

/**
 * @author Leexiaobu
 * @date 2021-03-10 14:21
 */
//@RestController
public class TestController {

//  @GetMapping("/hello")
  public void hello(String name) {
    System.out.println("Hello" + name);
  }
}