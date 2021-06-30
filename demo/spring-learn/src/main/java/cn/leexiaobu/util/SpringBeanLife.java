package cn.leexiaobu.util;

import cn.leexiaobu.App;
import cn.leexiaobu.bean.LazyBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Leexiaobu
 * @date 2021-06-24 14:47
 */
public class SpringBeanLife {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    Object simpleBean = ac.getBean("dependBean");
    System.out.println(ac.getBean("lazyBean"));
    System.out.println(ac.getBean("prototypeBean"));
    simpleBean = null;
    System.out.println(simpleBean);
    System.out.println(ac.getBean(LazyBean.class));
  }
}