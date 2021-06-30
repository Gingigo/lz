package cn.leexiaobu.service.impl;

import cn.leexiaobu.pojo.PoJo;
import cn.leexiaobu.pojo.Result;
import cn.leexiaobu.service.GreetingService;
import java.io.IOException;
import org.apache.dubbo.common.json.JSON;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Leexiaobu
 * @date 2021-02-24 22:41
 */
@DubboService
public class GreetingServiceImpl implements GreetingService {
//NettyHandler#messageReceived(ChannelHandlerContext, MessageEvent)
//  —> AbstractPeer#received(Channel, Object)
//    —> MultiMessageHandler#received(Channel, Object)
//      —> HeartbeatHandler#received(Channel, Object)
//        —> AllChannelHandler#received(Channel, Object)
//          —> ExecutorService#execute(Runnable)    // 由线程池执行后续的调用逻辑
// ChannelEventRunnable#run()
//  —> DecodeHandler#received(Channel, Object)
//    —> HeaderExchangeHandler#received(Channel, Object)
//      —> HeaderExchangeHandler#handleRequest(ExchangeChannel, Request)
//        —> DubboProtocol.requestHandler#reply(ExchangeChannel, Object)
//          —> Filter#invoke(Invoker, Invocation)
//            —> AbstractProxyInvoker#invoke(Invocation)
//              —> Wrapper0#invokeMethod(Object, String, Class[], Object[])
//                —> DemoServiceImpl#sayHello(String)
  @Override
  public String sayHello(String name) {
//    try{
//      Thread.sleep(1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    return "hello "+name+" "+ RpcContext.getContext().getAttachment("company");
    return "hello "+name;
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