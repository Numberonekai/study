package com.java.main.spi;

/**
 * @auther: kai2.wang
 * @date: 2019/10/8 10:34
 * @description:
 * @version: 1.0
 */
public class Demo1 implements Robot{
    @Override
    public void sayHello() {
        System.out.println("this is demo1 spi");
    }
}
