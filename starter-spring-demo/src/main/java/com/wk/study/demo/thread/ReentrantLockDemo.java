package com.wk.study.demo.thread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: kai2.wang
 * @date: 2019/11/14 08:55
 * @description:
 * @version: 1.0
 */
public class ReentrantLockDemo implements Runnable{

    private static ReentrantLock reentrantLock=new ReentrantLock();
    private  Integer data;

    public ReentrantLockDemo(Integer data) {
        this.data=data;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        LockSupport.park();
        System.out.println("---------"+data+"----"+Thread.currentThread().getId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            Thread  thread=new Thread(new ReentrantLockDemo(i));
            thread.start();
        }
        for(int i=0;i<100;i++){
            Thread  thread=new Thread(new ReentrantLockDemo(i));
            thread.interrupt();
        }
//        Thread thread=new Thread();
//        thread.start();
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.interrupted());


    }
}
