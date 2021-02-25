package cn.leexiaobu.spi;

import cn.leexiaobu.spi.Robot;

/**
 * @author Leexiaobu
 * @date 2021-02-24 10:58
 */
public class OptimusPrime implements Robot {

  @Override
  public void sayHello() {
    System.out.println("i am optimusPrime");
  }
}