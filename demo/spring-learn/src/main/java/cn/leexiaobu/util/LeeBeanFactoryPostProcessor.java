package cn.leexiaobu.util;

import cn.leexiaobu.App;
import cn.leexiaobu.bean.NotBean;
import cn.leexiaobu.bean.SimpleBean;
import java.util.Iterator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-22 12:50
 */
//@Component
public class LeeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(
      ConfigurableListableBeanFactory beanFactory) throws BeansException {
    Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
    System.out.println("LeeBeanFactoryPostProcessor:"+"postProcessBeanFactory 方法 ");

    //  修改SimpleBean为NotBean
//    updateSimpleBean(beanFactory);
  }

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    System.out.println(ac.getBean(NotBean.class));
//    System.out.println(ac.getBean(SimpleBean.class));
  }

  private void updateSimpleBean(ConfigurableListableBeanFactory beanFactory) {
    GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory
        .getBeanDefinition("simpleBean");
    beanDefinition.setBeanClass(NotBean.class);
    //修改的并不是Name 也是Class,无法修改BeanName
    beanDefinition.setBeanClassName("NotBean");
    System.out.println("===========");
  }

}