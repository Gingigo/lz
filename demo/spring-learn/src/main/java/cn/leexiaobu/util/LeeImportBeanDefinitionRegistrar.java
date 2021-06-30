package cn.leexiaobu.util;

import cn.leexiaobu.mapper.BlogMapper;
import cn.leexiaobu.mapper.UserMapper;
import java.util.ArrayList;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Leexiaobu
 * @date 2021-06-23 18:31
 */
public class LeeImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
      BeanDefinitionRegistry registry) {

    //假装这是扫描
    ArrayList<Class> list = new ArrayList<>();
    list.add(UserMapper.class);
    list.add(BlogMapper.class);
    for (Class s : list) {
      BeanDefinitionBuilder bdBuilder = BeanDefinitionBuilder
          .genericBeanDefinition(LeeFactoryBeanScan.class);
      AbstractBeanDefinition beanDefinition = bdBuilder.getBeanDefinition();
      MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
      propertyValues.add("mapperInterface", s);
      registry.registerBeanDefinition(s.getSimpleName(),
          beanDefinition);
    }
  }
}