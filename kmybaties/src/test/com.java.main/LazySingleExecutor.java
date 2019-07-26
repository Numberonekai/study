package com.java.main;

import com.java.main.pattern.singleton.lazy.LazySingleton;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/2 14:25
 * @Description:
 */
public class LazySingleExecutor implements Runnable {

    @Override
    public void run() {
        LazySingleton lazySingleton=LazySingleton.getInstance();
        System.out.println(Thread.currentThread()+"----"+lazySingleton);
    }
}
