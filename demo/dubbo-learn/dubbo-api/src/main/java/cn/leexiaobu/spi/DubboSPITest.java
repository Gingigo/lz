package cn.leexiaobu.spi;

import cn.leexiaobu.spi.Robot;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author Leexiaobu
 * @date 2021-02-24 13:06
 */
@Adaptive
public class DubboSPITest {

  public static void main(String[] args) {
    ExtensionLoader<Robot> extensionLoader =
        ExtensionLoader.getExtensionLoader(Robot.class);
    Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//    extensionLoader.getAdaptiveExtension()
    optimusPrime.sayHello();
    Robot bumblebee = extensionLoader.getExtension("bumblebee");
    bumblebee.sayHello();
  }
}