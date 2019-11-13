package com.wk.study.demo.ThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    ReentrantLock reentrantLock=new ReentrantLock();

    public ReentrantLockDemo(Integer id){
        reentrantLock.lock();
        System.out.println("并发数据的-----"+id);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
             new ReentrantLockDemo(i);
        }
    }
}
