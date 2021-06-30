package cn.leexiaobu.springboot;

import cn.leexiaobu.springboot.util.LeeImportSelector;
import org.springframework.context.annotation.Import;

/**
 * @author Leexiaobu
 * @date 2021-06-30 18:58
 */
@Import(LeeImportSelector.class)
public @interface LeeEnableAutoConfiguration {

}
