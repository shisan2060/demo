package com.jy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shisan on 2017/3/30.
 */
@Controller
@RequestMapping("/testController")
public class TestController {

    /**
     * getData
     *
     * @param a
     * @param b
     * @author shisan
     * @date 2017/3/31 下午2:41
     */
    @RequestMapping("/getData")
    @ResponseBody
    public String getData(int a, String b) {
        return "org.springframework.web.bind.annotation.ResponseBody";
    }
}
