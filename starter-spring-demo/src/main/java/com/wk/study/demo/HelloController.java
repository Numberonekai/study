package com.wk.study.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 11:11
 * @description:
 * @version: 1.0
 */
@RestController
public class HelloController {


    @GetMapping("hellow")
    public String hellowWorld(){
        System.out.println("this is hellow Controller");
        return "hellow";
    }
}
