package cn.leexiaobu.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-23 0:11
 */
//@Component
public class LeeBeanFactoryRegistryPostProcessor  implements BeanDefinitionRegistryPostProcessor {

  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
      throws BeansException {
    System.out.println("BeanDefinitionRegistry:"+"postProcessBeanDefinitionRegistry 方法 ");
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    System.out.println("BeanDefinitionRegistry:"+"postProcessBeanFactory 方法 ");

  }
}