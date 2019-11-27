package com.wk.study.demo.thread.coundownlatchdemo;

import java.util.concurrent.CountDownLatch;

/**
 * @auther: kai2.wang
 * @date: 2019/10/22 09:06
 * @description:
 * CountDownLatch  场景需求:
 *
 * 1.计数器  倒计时计数器
 * @version: 1.0
 */
public class CountDownLatchDemo {

    static CountDownLatch countDownLatch=new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread thread=new Thread(()->{
                try {
                    countDownLatch.await();
                    System.out.println("---开始释放--");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },Thread.currentThread().getName());
            thread.start();
        }
//
//        Thread thread2=new Thread(()->{
//            try {
//                countDownLatch.await();
//                System.out.println("---开始释放--");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },Thread.currentThread().getName());
//        thread2.start();
        System.out.println("已经开始了");
        countDownLatch.countDown();
//        System.out.println("线程结束了");
//        countDownLatch.countDown();
    }
}
