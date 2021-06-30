package cn.leexiaobu;

import cn.leexiaobu.bean.SimpleBean;
import cn.leexiaobu.util.LeeImportBeanDefinitionRegistrar;
import cn.leexiaobu.util.LeeScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author Leexiaobu
 * @date 2021-06-22 12:22
 */

@ComponentScan("cn.leexiaobu")
@LeeScan
public class App {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    System.out.println(ac.getBean(App.class));
  }
}