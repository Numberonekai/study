package com.java.main;

import com.java.main.pattern.singleton.threadLocal.ThreadLocalSingleton;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/11 15:47
 * @Description:
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {

        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());


//        Thread thread=new Thread(()->{ThreadLocalSingleton.getInstance();
//            System.out.println(ThreadLocalSingleton.getInstance());});
//        thread.start();
//
//        Thread thread2=new Thread(()->{ThreadLocalSingleton.getInstance();     System.out.println(ThreadLocalSingleton.getInstance());});
//        thread2.start();

    }
}
