package com.study.main;

/**
 * @auther: kai2.wang
 * @date: 2019/9/2 11:13
 * @description:
 * @version: 1.0
 */
public class ThreadDemo1 {

    private  static int count=0;


    public Thread getThreadDemo1() {

        Thread thread=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        };
        return thread;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new ThreadDemo1().getThreadDemo1().start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
