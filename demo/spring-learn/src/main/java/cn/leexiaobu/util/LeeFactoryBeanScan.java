package cn.leexiaobu.util;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Leexiaobu
 * @date 2021-06-23 18:34
 */
//@Component
public class LeeFactoryBeanScan implements FactoryBean {


  Class mapperInterface;

  public Class getMapperInterface() {
    return mapperInterface;
  }

  public void setMapperInterface(Class mapperInterface) {
    this.mapperInterface = mapperInterface;
  }

  public LeeFactoryBeanScan(){}

  public LeeFactoryBeanScan(Class mapperInterface) {
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