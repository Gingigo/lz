package cn.leexiaobu.bean;

import cn.leexiaobu.App;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-29 12:50
 */
@Component
public class LookupBean {
  SimpleBean simpleBean;
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    System.out.println(ac.getBean("simpleBean"));
    System.out.println(ac.getBean(SimpleBean.class));
  }
}