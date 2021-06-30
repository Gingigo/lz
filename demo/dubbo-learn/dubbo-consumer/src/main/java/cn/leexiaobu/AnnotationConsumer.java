package cn.leexiaobu;

import java.io.IOException;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "cn.leexiaobu.service")
@PropertySource("classpath:spring/dubbo-consumer.properties")
//@ComponentScan("cn.leexiaobu.service")
@SpringBootApplication
public class AnnotationConsumer {
  public static void main(String[] args) throws IOException {
    System.out.println("consumer start");
    SpringApplication.run(AnnotationConsumer.class, args);
    System.in.read();
  }
}