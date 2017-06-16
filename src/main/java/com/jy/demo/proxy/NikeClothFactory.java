package com.jy.demo.proxy;

/**
 * 被代理类
 *
 * @author shisan
 * @create 2017-04-25 上午9:19
 **/
public class NikeClothFactory implements ClothFactory{

    public void productCloth() {
        System.out.println("NIKE工厂生产一批衣服");
    }
}
