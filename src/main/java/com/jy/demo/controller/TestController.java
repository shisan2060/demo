package com.jy.demo.controller;

import com.jy.demo.model.TestModel;
import com.jy.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DemoService demoService;

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
        System.out.println(demoService.getString("shisan"));
        return "org.springframework.web.bind.annotation.ResponseBody......,org.springframework.web.bind.annotation.ResponseBody 123456";
    }

    public String getData_branch_a(int a, String b) {
        System.out.println(a+b);
        System.out.println("我也测试冲突 master");
        System.out.println("测试代码的冲突branch_a");
        
        return "getData_branch_a";
    }

    public static void main(String[] args) {
        TestModel tm = new TestModel();
        tm.setAge(10);
    }
}
