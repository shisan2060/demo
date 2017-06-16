package com.jy.demo.model;

import com.jy.demo.annotion.FruitColor;
import com.jy.demo.annotion.FruitName;
import com.jy.demo.annotion.FruitProvider;

/**
 * App
 *
 * @author shisan
 * @create 2017-04-13 下午4:33
 **/
public class Apple {
    /* 名称 */
    @FruitName("苹果")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.Red)
    private String color;

    @FruitProvider(id = 1, name = "西河供应商", address = "杭州市西湖区")
    private String appProvider;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppProvider() {
        return appProvider;
    }

    public void setAppProvider(String appProvider) {
        this.appProvider = appProvider;
    }

    @Override
    public String toString() {
        return "水果的品种是 苹果";
    }
}
