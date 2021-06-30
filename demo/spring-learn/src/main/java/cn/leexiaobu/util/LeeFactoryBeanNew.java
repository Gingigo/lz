package cn.leexiaobu.util;

import cn.leexiaobu.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Leexiaobu
 * @date 2021-06-23 18:34
 */
//@Component
public class LeeFactoryBeanNew implements FactoryBean {


  Class mapperInterface;

  public LeeFactoryBeanNew(Class mapperInterface) {
    this.mapperInterface = mapperInterface;
  }


  @Override
  public Object getObject() throws Exception {
    Object mapper = LeeSqlSession.getMapper(mapperInterface);
    return mapper;
  }

  @Override
  public Class<?> getObjectType() {

    return mapperInterface;
  }

  @Override
  public boolean isSingleton() {
    return FactoryBean.super.isSingleton();
  }
}