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

    @RequestMapping("/getData")
    @ResponseBody
    public String getData(){
        return "data";
    }
}
