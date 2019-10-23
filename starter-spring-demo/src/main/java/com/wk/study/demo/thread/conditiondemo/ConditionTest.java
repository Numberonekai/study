package com.wk.study.demo.thread.conditiondemo;

import org.springframework.context.annotation.Conditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: kai2.wang
 * @date: 2019/10/15 08:41
 * @description:
 * @version: 1.0
 */
public class ConditionTest {


    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        new Thread(new ConditionWait(lock,condition)).start();
        new Thread(new ConditionNotify(lock,condition)).start();

    }
}
