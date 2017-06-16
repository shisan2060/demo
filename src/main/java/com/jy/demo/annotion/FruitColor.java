package com.jy.demo.annotion;

import java.lang.annotation.*;

/**
 * 水果颜色 注解
 * User : shisan
 * DateTime : 2017/4/13 下午4:23
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /* 颜色枚举类 */
    public enum Color {
        Blue,
        Red,
        Green
    }

    ;

    /* 水果颜色 默认为蓝色 */
    Color fruitColor() default Color.Blue;
}
