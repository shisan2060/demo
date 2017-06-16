package com.jy.demo.util;

import com.jy.demo.annotion.FruitColor;
import com.jy.demo.annotion.FruitName;
import com.jy.demo.annotion.FruitProvider;

import java.lang.reflect.Field;

/**
 * 注解处理器
 *
 * @author shisan
 * @create 2017-04-13 下午4:41
 **/
public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(fruitName.value());
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                System.out.println(fruitColor.fruitColor());
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println(fruitProvider.id() + "," + fruitProvider.name() + ", " + fruitProvider.address());
            }
        }
    }
}
