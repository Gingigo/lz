package cn.leexiaobu.service;

import cn.leexiaobu.mapper.BlogMapper;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Leexiaobu
 * @date 2021-06-23 21:59
 */
//@Component
public class BolgService {

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
  BlogMapper blogMapper;

  public List<Map<String, Object>> query() {
  return  blogMapper.query();
  }

  public List<Map<String, Object>> getById() {
    return  blogMapper.getById();
  }
}