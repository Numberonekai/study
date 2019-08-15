package com.spring.demo.Controller;

import com.spring.demo.annotation.KService;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/30 16:30
 * @Description:
 */
@KService("demoService")
public class DemoServiceImpl implements  DemoService {

    @Override
    public String getData() {
        return "this is Demo ServiceImpl";
    }
}
