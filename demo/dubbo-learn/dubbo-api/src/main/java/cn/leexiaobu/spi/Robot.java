package cn.leexiaobu.spi;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author Leexiaobu
 * @date 2021-02-24 10:58
 */
@SPI
public interface Robot {
  public void sayHello();
}