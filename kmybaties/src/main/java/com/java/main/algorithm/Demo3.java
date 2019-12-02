package com.java.main.algorithm;

import java.util.concurrent.*;

/**
 * @auther: kai2.wang
 * @date: 2019/12/2 11:34
 * @description:
 * @version: 1.0
 */
public class Demo3 implements Runnable{

    public static void main(String[] args) {
        ExecutorService executorService=  new ThreadPoolExecutor(1, 3,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1));

        for (int i = 0; i < 4; i++) {
            executorService.execute(new Demo3());
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("000000000");
    }
}
