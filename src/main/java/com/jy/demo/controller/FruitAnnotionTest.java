package com.jy.demo.controller;

import com.jy.demo.model.Apple;
import com.jy.demo.util.FruitInfoUtil;

/**
 * FruitAnnotionTest
 *
 * @author shisan
 * @create 2017-04-13 下午4:51
 **/
public class FruitAnnotionTest {
    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}
