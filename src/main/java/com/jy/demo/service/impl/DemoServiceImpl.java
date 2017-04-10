package com.jy.demo.service.impl;/**
 * User : shisan
 * DateTime : 2017/4/10 下午2:10
 */

import com.jy.demo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * DemoServiceImpl
 *
 * @author shisan
 * @create 2017-04-10 下午2:10
 **/
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getString(String str) {
        return String.format("Hello ~ %s",str);
    }
}
