package com.jy.demo.annotion;

import java.lang.annotation.*;

/**
 * 水果供应商 注解
 * User : shisan
 * DateTime : 2017/4/13 下午4:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    /* 供应商Id */
    int id() default -1;

    /* 供应商名称 */
    String name() default "";

    /* 供应商地址 */
    String address() default "";
}
