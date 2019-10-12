package com.wk.study.demo.five;

import com.spring.spi.FormatTempleate;
import com.spring.spi.form.JsonFormat;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 18:10
 * @description:
 * @version: 1.0
 */
public class FiveDemo {

    public static void main(String[] args) {
        JsonFormat jsonFormat=new JsonFormat();
        FormatTempleate formatTempleate=new FormatTempleate(null,jsonFormat);
        UserInfo userInfo=new UserInfo();
        System.out.println(formatTempleate.format(userInfo));
    }
}
