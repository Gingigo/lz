package cn.leexiaobu.service;

import cn.leexiaobu.mapper.UserMapper;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-23 21:59
 */
//@Component
public class UserService {

  /**
  * 1.必须是个对象
  * 2.对象必须实现UserMapper接口
  * 3.然后还在Spring容器中
   *  对象注入
   *  3.1 FactoryBean
   *  3.2 @Bean
   *  3.3 ac.getBeanFactory.registerSingleton
   *
   *  类交给Spring管理
   *  3.4 Scan @Service
   *  3.5 Postprocessor
   *
   * /
  /*可选方法1.*/
  @Autowired
  UserMapper userMapper;

  public List<Map<String, Object>> query() {
  return  userMapper.query();
  }

  public List<Map<String, Object>> getById() {
    return  userMapper.getById();
  }
}