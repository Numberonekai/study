package com.spring.demo.Controller;


import com.example.demo.annotation.*;
import com.spring.demo.annotation.Controller;
import com.spring.demo.annotation.RequestMapping;
import com.spring.demo.annotation.RequestParam;
import com.spring.demo.annotation.Resource;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:15
 * @Description:
 */
@Controller("demo")
public class DemoController {

    @Resource("demoService")
    public DemoService demoService;

    @RequestMapping("test")
    public String queryResult(@RequestParam("name") String name){
        return demoService.getData()+name;
    }
}
