package com.wk.study.demo.ThreadDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExectorsDemo implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Name----->"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService exectors= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            exectors.execute(new ExectorsDemo());
        }
        ((ExecutorService) exectors).shutdown();
    }
}
