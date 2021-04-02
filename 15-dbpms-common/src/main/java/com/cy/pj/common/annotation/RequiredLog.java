package com.cy.pj.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target 注解描述我们的注解可以描述哪些成员
 * @Retention 注解描述我们的注解可以何时有效
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiredLog {//自定义注解
    //借助此属性指定具体操作名
    String operation() default "";
}
