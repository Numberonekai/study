package com.java.main;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/2 14:24
 * @Description:
 */
public class LazySingletonDemo {

    public static void main(String[] args) {

        Thread thread=new Thread(new LazyDoubleCheckSingleton());
        thread.start();

        Thread thread1=new Thread(new LazyDoubleCheckSingleton());
        thread1.start();

        System.out.println("------");
    }
}
