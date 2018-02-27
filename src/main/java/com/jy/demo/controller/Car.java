package com.jy.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Car
 *
 * @author shisan
 * @create 2017-10-30 上午11:26
 **/
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public static void coll() {
        System.out.println("Collided " );
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }


    public static void main(String[] args) {
        //第一种方法引用是构造器引用，它的语法是Class::new   或者更一般的Class< T >::new。请注意构造器没有参数。
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);

        //第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数
        cars.forEach(Car::collide);
        cars.forEach(e->Car.coll());

        //第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
        cars.forEach(Car::repair);

        //第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
        cars.forEach(car::follow);


    }
}
