package com.java.main.pattern.singleton.hungry;

/**
 * @Auther: kai2.wang   饿汉单例模式
 * @Date: 2019/7/2 10:29
 * @Description:
 */
public class HungrySingleton {


    private static final HungrySingleton  hungrySignleton=new HungrySingleton();

    public static HungrySingleton getInstance(){
        return hungrySignleton;
    }
}
