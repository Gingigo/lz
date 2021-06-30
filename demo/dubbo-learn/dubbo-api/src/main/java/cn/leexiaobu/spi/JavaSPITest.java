package cn.leexiaobu.spi;

import cn.leexiaobu.spi.Robot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.ServiceLoader;

/**
 * @author Leexiaobu
 * @date 2021-02-24 11:02
 */
public class JavaSPITest {

  public static void main(String[] args) throws IOException {
    ServiceLoader<Robot> robots = ServiceLoader.load(Robot.class);
    System.out.println(ClassLoader.getSystemClassLoader());
    System.out.println("JAVA SPI");
    robots.forEach(Robot::sayHello);
  }
}