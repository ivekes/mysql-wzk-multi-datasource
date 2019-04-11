package com.wzk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.wzk.core.RwDataSourceHolder;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DynamicDataSourceAnnotation {
    //dataSource 自定义注解的参数sdas
    String dataSource() default RwDataSourceHolder.MASTER;
}
