package com.jy.demo.controller;

import java.util.Arrays;

/**
 * a
 *
 * @author shisan
 * @create 2017-05-11 上午11:30
 **/
public class a {

    public static void main(String[] args) {
        //Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        Arrays.asList("a", "b", "c").sort((e1,e2) ->  {
            int i=e1.compareTo(e2);
            return i;
        });
    }
}
