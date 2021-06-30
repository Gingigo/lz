package cn.leexiaobu.util;

import cn.leexiaobu.App;
import cn.leexiaobu.mapper.BlogMapper;
import cn.leexiaobu.mapper.UserMapper;
import cn.leexiaobu.service.UserService;
import javax.jws.soap.SOAPBinding.Use;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Leexiaobu
 * @date 2021-06-23 22:06
 */
//@Component
public class SpringInjectBean {

  /**
   * 1.UserMapper必须是个对象 2.对象必须实现UserMapper接口 3.然后还在Spring容器中
   */
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    test8(ac);
  }

  //直接通过反射执行可行
  static void test1(AnnotationConfigApplicationContext ac) {
    UserMapper mapper = (UserMapper) LeeSqlSession.getMapper(UserMapper.class);
    System.out.println(mapper.query());
    System.out.println(mapper.getById());
  }

  //通过Service 获取 发现UserService里找不到UserMapper实例对象
  static void test2(AnnotationConfigApplicationContext ac) {
    UserService bean = ac.getBean(UserService.class);
    System.out.println(bean.query());
    System.out.println(bean.getById());
  }

  //通过注册 BeanFactory.registerSingleton方法将对象注入
  // 测试直接复制
  // mybatis显然不是这个方法，否则使用时，多一个mapper就需要多注册一次
  static void test3() {
    UserMapper userMapper = (UserMapper) LeeSqlSession.getMapper(UserMapper.class);
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    ac.register(App.class);
    ac.getBeanFactory().registerSingleton("mapper", userMapper);
    ac.refresh();
    test2(ac);
  }

  //在任意被扫描类里使用@Bean,例如本类加上@Component
//  @Bean
  public UserMapper getUserMapper() {
    return (UserMapper) LeeSqlSession.getMapper(UserMapper.class);
  }

  static void test4(AnnotationConfigApplicationContext ac) {
    UserService bean = ac.getBean(UserService.class);
    System.out.println(bean.query());
    System.out.println(bean.getById());
  }

  //使用FactoryBean  在LeeFactoryBeanOld 上加入Component
  static void test5(AnnotationConfigApplicationContext ac) {
    LeeFactoryBeanOld leeFactoryBeanOld = ac.getBean(LeeFactoryBeanOld.class);
    System.out.println(leeFactoryBeanOld);
    //这里返回的是由Jdk动态代理产生的对象，并执行hashcode方法
    System.out.println(ac.getBean("leeFactoryBeanOld"));
    System.out.println(ac.getBean("&leeFactoryBeanOld"));
    try {
      UserMapper object = (UserMapper) leeFactoryBeanOld.getObject();
      object.query();
      object.getById();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  //修改LeeFactoryBeanNew
  //通过xml注入 或者@Bean 方法
//  @Bean
  public LeeFactoryBeanNew getLeeFactoryBeanNew() {
    return new LeeFactoryBeanNew(UserMapper.class);
  }

  static void test6(AnnotationConfigApplicationContext ac) {
    LeeFactoryBeanNew factoryBeanNew = ac.getBean(LeeFactoryBeanNew.class);
    try {
      UserMapper object = (UserMapper) factoryBeanNew.getObject();
      object.getById();
      object.query();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //
  //
  //
  //

  /**
   * 使用LeeBeanFactoryScan
   * 通过xml注入 或者@MapperScan注解，
   * 目前主要问题是自定义的FactoryBean在Spring容器中
   * 并且自定义FactoryBean批量把生成的代理对象注册到Spring中
   * 1.加注解  不能传参
   * 2.xml 或者 @Bean 可以传参，但是一次只能传一个 不能扫描
   * 3.扩展Spring 把FactoryBean转换成BD,
   */
  static void test7(AnnotationConfigApplicationContext ac) {
    LeeFactoryBeanScan bean = ac.getBean(LeeFactoryBeanScan.class);
    try {
      UserMapper object = (UserMapper) bean.getObject();
      object.getById();
      object.query();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  static void test8(AnnotationConfigApplicationContext ac) {
    UserMapper userMapper = ac.getBean(UserMapper.class);
    userMapper.getById();
    userMapper.query();
    BlogMapper blogMapper = ac.getBean(BlogMapper.class);
    blogMapper.getById();
    blogMapper.query();
  }
}