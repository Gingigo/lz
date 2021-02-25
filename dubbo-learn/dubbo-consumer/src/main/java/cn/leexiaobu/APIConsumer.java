package cn.leexiaobu;

import cn.leexiaobu.service.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author Leexiaobu
 * @date 2021-02-24 23:15
 */
public class APIConsumer {

  public static void main(String[] args) {
    //9.服务引用对象
    ReferenceConfig<GreetingService> referenceConfig = new ReferenceConfig<>();
    //10 设置程序信息
    referenceConfig.setApplication(new ApplicationConfig("dubbo-consumer"));
    //11.设置注册中心
    referenceConfig.setRegistry(new RegistryConfig("zookeeper://192.168.31.192:2181"));
    //12.设置服务接口和超时时间
    referenceConfig.setInterface(GreetingService.class);
    referenceConfig.setTimeout(5000);
    //13.设置自定义负载均衡策略与集群容错机制
//    referenceConfig.setLoadbalance("myloadBalance");
//    referenceConfig.setCluster("myBroadcast");
    //14.设置服务分组与版本
    referenceConfig.setGroup("dubbo");
    referenceConfig.setVersion("1.0.0");
    //15.引用服务
    GreetingService greetingService = referenceConfig.get();
    //16.设置隐式参数
    RpcContext.getContext().setAttachment("company","Lee");
    //17.调用服务
    System.out.println(greetingService.sayHello("leexiaobu"));
  }
}