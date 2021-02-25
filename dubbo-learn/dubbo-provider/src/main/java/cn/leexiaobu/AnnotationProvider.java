package cn.leexiaobu;

import java.io.IOException;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Leexiaobu
 * @date 2021-02-25 9:37
 */
@Configuration
@EnableDubbo(scanBasePackages = "cn.leexiaobu.service.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class AnnotationProvider {

  public static void main(String[] args) throws IOException {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AnnotationProvider.class);
    context.start();
    System.out.println("server is start ");
    System.in.read();
  }
}