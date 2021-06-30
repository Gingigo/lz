package cn.leexiaobu.util;

import cn.leexiaobu.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Leexiaobu
 * @date 2021-06-23 18:34
 */
//@Component
public class LeeFactoryBeanOld implements FactoryBean {

  @Override
  public Object getObject() throws Exception {
    UserMapper mapper =(UserMapper) LeeSqlSession.getMapper(UserMapper.class);
    return mapper;
  }

  @Override
  public Class<?> getObjectType() {
    return UserMapper.class;
  }

  @Override
  public boolean isSingleton() {
    return FactoryBean.super.isSingleton();
  }
}