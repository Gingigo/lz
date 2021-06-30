package cn.leexiaobu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-24 16:02
 */
@Component
public class DependBean {

  @Autowired
  SimpleBean simpleBean;

  public DependBean() {
    System.out.println("DependBean init");
  }

  @PostConstruct
  void methodBefore() {
    System.out.println("--lifecycle before");
  }

  @PreDestroy
  void methodDestroy() {
    System.out.println("--lifecycle destroy");

  }


}