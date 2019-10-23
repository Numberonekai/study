package com.wk.study.demo.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther: kai2.wang
 * @date: 2019/10/22 09:18
 * @description:
 * @version: 1.0
 */
public class CycliBarrierDemo implements Runnable {


    @Override
    public void run() {
        System.out.println("end");
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3,new CycliBarrierDemo());
        new Demo(cyclicBarrier).start();
        new Demo(cyclicBarrier).start();
        new Demo(cyclicBarrier).start();
    }

    static class  Demo extends Thread{
        private CyclicBarrier cyclicBarrier;

        public Demo(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("--start--");
                cyclicBarrier.await();
                System.out.println("-----");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
