package com.wk.study.demo.thread.conditiondemo;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @auther: kai2.wang
 * @date: 2019/10/15 08:43
 * @description:
 * @version: 1.0
 */
public class ConditionWait implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(" Condition Wait is start --->"+new Date().toInstant());
            condition.await();
            System.out.println(" Condition Wait is end --->"+new Date().toInstant());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
