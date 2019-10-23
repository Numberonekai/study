package com.java.main.spi;

import java.util.ServiceLoader;

/**
 * @auther: kai2.wang
 * @date: 2019/10/8 10:37
 * @description:
 * @version: 1.0
 */
public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader=ServiceLoader.load(Robot.class);
        serviceLoader.forEach(Robot::sayHello);
        System.out.println("------->");
    }
}
