package cn.leexiaobu.springboot.util;

import java.util.function.Predicate;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Leexiaobu
 * @date 2021-06-30 18:54
 */
public class LeeImportSelector implements ImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {

    return new String[0];
  }

  @Override
  public Predicate<String> getExclusionFilter() {
    return ImportSelector.super.getExclusionFilter();
  }




}