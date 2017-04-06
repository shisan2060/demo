package com.jy.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 测试Controller
 *
 * @Author shisan
 * @Date 2017/3/31 下午2:52
 */
@Controller
@RequestMapping("/testController")
public class TestController {

    /**
     * 获取数据
     *
     * @param a 参数a
     * @param b 参数b
     * @author shisan
     * @date 2017/3/31 下午2:41
     */
    @RequestMapping("/getData")
    @ResponseBody
    public String getData(int a, String b) {
        System.out.println(a+b);
        return "org.springframework.web.bind.annotation.ResponseBody";
    }

    public String getData_branch_a(int a, String b) {
        System.out.println(a+b);
        return "getData_branch_a";
    }
}
