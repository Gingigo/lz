package cn.leexiaobu;

import cn.leexiaobu.service.GreetingService;
import cn.leexiaobu.service.impl.GreetingServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

/**
 * @author Leexiaobu
 * @date 2021-02-24 22:47
 */
public class ApiProvider {

  public static void main(String[] args) throws IOException {
    //1.创建ServiceConfig
    ServiceConfig<GreetingService> serviceServiceConfig= new ServiceConfig<>();
    //2.设置应用程序配置
    serviceServiceConfig.setApplication(new ApplicationConfig("service-provider-A"));
    //3.设置服务器注册中心信息
    RegistryConfig registryConfig= new RegistryConfig("zookeeper://192.168.31.192:2181");
    serviceServiceConfig.setRegistry(registryConfig);
    //4.设置接口与实现类
    serviceServiceConfig.setInterface(GreetingService.class);
    serviceServiceConfig.setRef(new GreetingServiceImpl());
    //5.设置分组与版本
    serviceServiceConfig.setGroup("dubbo");
    serviceServiceConfig.setVersion("1.0.0");
    //6.设置线程池策略
//    HashMap<String,String> map = new HashMap<>();
//    map.put("threadpool","mythreadpool");
//    serviceServiceConfig.setParameters(map);
    //7.导出服务
    serviceServiceConfig.export();
    //8.挂起服务
    System.out.println("server is start ");
    System.in.read();
  }
}