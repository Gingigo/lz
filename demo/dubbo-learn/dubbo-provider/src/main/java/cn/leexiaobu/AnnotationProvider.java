package cn.leexiaobu;

import java.util.concurrent.CountDownLatch;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Leexiaobu
 * @date 2021-02-25 9:37
 */
@Configuration
@EnableDubbo(scanBasePackages = "cn.leexiaobu.service.impl")
@PropertySource("classpath:/spring/dubbo-provider.properties")
@SpringBootApplication
public class AnnotationProvider {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("dubbo provider=====");
    SpringApplication.run(AnnotationProvider.class, args);
    new CountDownLatch(1).await();
  }
}