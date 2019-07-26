package com.java.main;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/5 14:32
 * @Description:
 */
public class LazyDoubleCheckSingleton implements  Runnable{

    @Override
    public void run() {
        com.java.main.pattern.singleton.lazy.LazyDoubleCheckSingleton lazyDoubleCheckSingleton= com.java.main.pattern.singleton.lazy.LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread()+"----"+lazyDoubleCheckSingleton);
    }
}
