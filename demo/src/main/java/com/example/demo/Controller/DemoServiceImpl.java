package com.example.demo.Controller;

import com.example.demo.annotation.Service;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/30 16:30
 * @Description:
 */
@Service("demoService")
public class DemoServiceImpl implements  DemoService {

    @Override
    public String getData() {
        return "this is Demo ServiceImpl";
    }
}
