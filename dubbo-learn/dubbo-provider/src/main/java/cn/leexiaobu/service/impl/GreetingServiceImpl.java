package cn.leexiaobu.service.impl;

import cn.leexiaobu.pojo.PoJo;
import cn.leexiaobu.pojo.Result;
import cn.leexiaobu.service.GreetingService;
import java.io.IOException;
import org.apache.dubbo.common.json.JSON;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author Leexiaobu
 * @date 2021-02-24 22:41
 */
@DubboService
public class GreetingServiceImpl implements GreetingService {

  @Override
  public String sayHello(String name) {
    try{
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "hello "+name+" "+ RpcContext.getContext().getAttachment("company");
  }

  @Override
  public Result<String> testGeneric(PoJo poJo) {
    Result<String> result = new Result<>();
      result.setSuccess(true);
    try{
      result.setData(JSON.json(poJo));
    }catch (IOException e){
      e.printStackTrace();
    }
    return result;
  }
}