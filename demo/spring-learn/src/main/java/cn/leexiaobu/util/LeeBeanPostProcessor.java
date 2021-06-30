package cn.leexiaobu.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-23 0:26
 */
//@Component
public class LeeBeanPostProcessor implements BeanPostProcessor {
  public LeeBeanPostProcessor () {
    System.out.println("LeeBeanPostProcessor 实例化......");
  }
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    System.out.println("spring中bean实例:" + beanName + " 初始化之前处理......");
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("spring中bean实例:" + beanName + " 初始化之后处理......");
    return bean;
  }
}