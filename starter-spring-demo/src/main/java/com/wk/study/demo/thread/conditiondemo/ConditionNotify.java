package com.wk.study.demo.thread.conditiondemo;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: kai2.wang
 * @date: 2019/10/15 08:43
 * @description:
 * @version: 1.0
 */
public class ConditionNotify implements Runnable{

    private Lock lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(" Condition Notify is start --->"+new Date().toInstant());
            condition.signal();
            System.out.println(" Condition Notify is end --->"+new Date().toInstant());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
