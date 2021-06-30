package cn.leexiaobu.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.ibatis.annotations.Select;

/**
 * @author Leexiaobu
 * @date 2021-06-23 22:54
 */
public class LeeSqlSession {

  public static Object getMapper(Class clazz) {
    Class[] iclazz = new Class[]{clazz};
    return Proxy
        .newProxyInstance(clazz.getClassLoader(), iclazz, new LeeInvocationHandler());
  }

  static class LeeInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      Select annotation = method.getAnnotation(Select.class);
      if(annotation!=null){
        String value = annotation.value()[0];
        System.out.println(method.getName() + "--exec sql :" + value);
      }
     return null;
    }
  }

}