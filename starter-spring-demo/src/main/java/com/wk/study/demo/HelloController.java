package com.wk.study.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 11:11
 * @description:
 * @version: 1.0
 */
@RestController
public class HelloController {


    @GetMapping(name="hellowWorld")
    public String hellowWorld(@RequestParam String aa,@RequestParam String bb){
        System.out.println("this is hellow Controller");

        StringBuilder str=new StringBuilder();
        str.append("select * from ");
        if(aa==null || aa.equals("")){
            str.append("where aa=1");
        }
        return  null;
    }
}
