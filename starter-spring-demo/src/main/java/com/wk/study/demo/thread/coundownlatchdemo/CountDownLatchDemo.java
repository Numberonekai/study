package com.wk.study.demo.thread.coundownlatchdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @auther: kai2.wang
 * @date: 2019/10/22 09:06
 * @description:
 * @version: 1.0
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch=new CountDownLatch(2);

    public static void main(String[] args) {

        Thread thread=new Thread(()->{
            try {
                countDownLatch.await();
                System.out.println("---开始释放--");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },Thread.currentThread().getName());
        thread.start();
        System.out.println("已经开始了");
        countDownLatch.countDown();

    }
}
