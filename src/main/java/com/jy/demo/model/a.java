package com.jy.demo.model;

/**
 * a
 *
 * @author shisan
 * @create 2017-05-11 上午11:31
 **/
public class a extends TestModel{

    @Override
    public void setAge(int age) {
        this.setAge(this.getAge()+20);
        super.setAge(age);
    }
}
