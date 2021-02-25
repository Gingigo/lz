package cn.leexiaobu;

import cn.leexiaobu.service.AgentService;
import cn.leexiaobu.service.GreetingService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "cn.leexiaobu.service")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan("cn.leexiaobu.service")
public class AnnotationConsumer {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AnnotationConsumer.class);
    AgentService bean = context.getBean(AgentService.class);
    String leexiaobu = bean.sayHello("leexiaobu");
    System.out.println(leexiaobu);
  }
}