package com.wk.study.demo.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @auther: kai2.wang
 * @date: 2019/10/22 09:18
 * @description:  实现限流
 * 1.公平和非公平
 *
 * @version: 1.0
 */
public class SeamphoreDemo {


    public static void main(String[] args) {
        Semaphore seamphore=new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Demo(seamphore,i).start();
        }

    }

    static class Demo extends Thread{
        private Semaphore seamphore;
        private Integer count;

        public Demo(Semaphore seamphore, Integer count) {
            this.seamphore = seamphore;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                seamphore.acquire();
                System.out.println("----开始---"+count+"--时间--"+System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("----释放---"+count+"--时间--"+System.currentTimeMillis());
                seamphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
