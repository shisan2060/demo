package com.jy.demo.controller;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java 反射学习
 *
 * @author shisan
 * @create 2017-04-13 上午10:20
 **/
public class ReflectTestController {
    public static void main(String[] args) {
        try {
            //ReflectTestController reflectTestController = new ReflectTestController();
            //System.out.println(reflectTestController.getClass());
            //Class<?> class1 = Class.forName("com.jy.demo.model.TestModel");


            TestController testController = new TestController();
            Class<?> clz = testController.getClass();
            System.out.println("类名称" + clz.getName());
            Method[] methods = clz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println("第" + i + "个方法开始");
                System.out.println("方法名称" + methods[i].getName());
                System.out.println("");
                // 获取方法修饰符
                int modifier = methods[i].getModifiers();
                System.out.print("修饰符" + Modifier.toString(modifier) + " ");
                //获取方法返回值类型
                Class<?> returnTypeClass = methods[i].getReturnType();
                System.out.println("返回值类型:" + returnTypeClass.getName());
                //获取方法参数类型
                Class<?>[] parameterTypeClass = methods[i].getParameterTypes();
                for (int j = 0; j < parameterTypeClass.length; j++) {
                    System.out.println("第" + j + "个 ：" + parameterTypeClass[j]);
                }

            }
            System.out.println("==============================");
            Class clazz = Class.forName("com.jy.demo.model.TestModel");
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("setName", String.class);
            method.invoke(obj, "zhangsan");
            System.out.println(clazz.getMethod("getName").invoke(obj));

            //操作类的属性
            Field field = clazz.getDeclaredField("age");
            field.setAccessible(true);
            field.set(obj, 20);
            System.out.println(field.get(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
