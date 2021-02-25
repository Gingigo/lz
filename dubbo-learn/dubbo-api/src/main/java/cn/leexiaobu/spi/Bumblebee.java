package cn.leexiaobu.spi;

import cn.leexiaobu.spi.Robot;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author Leexiaobu
 * @date 2021-02-24 10:58
 */
public class Bumblebee implements Robot {

  @Override
  @Adaptive
  public void sayHello() {
    System.out.println("i am Bumblebee");
  }
}