package cn.leexiaobu.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Import;

/**
 * @author Leexiaobu
 * @date 2021-06-24 2:53
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(LeeImportBeanDefinitionRegistrar.class)
public @interface LeeScan {

}
