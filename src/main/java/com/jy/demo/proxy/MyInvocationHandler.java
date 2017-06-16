package com.jy.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * MyInvocationHandler ①必须实现InvocationHandler接口
 *
 * @author shisan
 * @create 2017-04-25 上午9:21
 **/
public class MyInvocationHandler implements InvocationHandler {
    //② 声明接口的代理类
    private Object obj;

    //③ 创建一个方法实例化代理类
    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    //④ 实现接口InvacationHandler的方法
    // 此方法实现：当调用代理类的对象方法的时候，都会转换到它上调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal = method.invoke(obj, args);
        return returnVal;
    }
}
