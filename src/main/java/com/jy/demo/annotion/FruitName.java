package com.jy.demo.annotion;

import java.lang.annotation.*;

/**
 * 水果名称 注解
 * User : shisan
 * DateTime : 2017/4/13 下午4:13
 */
@Target(ElementType.FIELD) //设置作用域
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
