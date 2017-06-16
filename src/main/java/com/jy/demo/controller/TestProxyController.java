package com.jy.demo.controller;

import com.jy.demo.proxy.ClothFactory;
import com.jy.demo.proxy.MyInvocationHandler;
import com.jy.demo.proxy.NikeClothFactory;

/**
 * TestProxyController
 *
 * @author shisan
 * @create 2017-04-25 上午9:27
 **/
public class TestProxyController {

    public static void main(String[] args) {
        //① 老规矩：创建一个被代理对象
        NikeClothFactory nike = new NikeClothFactory();
        //②老规矩：创建一个代理类对象
        MyInvocationHandler hander = new MyInvocationHandler();
        ClothFactory proxyCloth = (ClothFactory) hander.bind(nike);
        //③ 老规矩：调用代理类对象的方法
        proxyCloth.productCloth();
     }
}
