package cn.leexiaobu.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-22 12:59
 */
@Component
public class SimpleBean {
  @Autowired
  DependBean simpleBean;
    public SimpleBean(){
      System.out.println("simpleBean init ");
    }
}