package cn.leexiaobu.bean;

import cn.leexiaobu.App;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Leexiaobu
 * @date 2021-06-29 12:50
 */
@Component
public class InjectBean {


 public  SimpleBean simpleBean;

  public  DependBean dependBean;

  public void setSimpleBean(SimpleBean simpleBean) {
    this.simpleBean = simpleBean;
  }



  public SimpleBean getSimpleBean() {
    return simpleBean;
  }
  public DependBean getDependBean() {
    return dependBean;
  }

  public void setDependBean(DependBean dependBean) {
    this.dependBean = dependBean;
  }

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    ConfigurableListableBeanFactory beanFactory = ac.getBeanFactory();
    InjectBean bean = beanFactory.getBean(InjectBean.class);
    System.out.println(bean);
    System.out.println(bean.getDependBean());
    System.out.println(bean.getSimpleBean());

  }
}