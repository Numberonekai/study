package com.java.main.pattern.singleton.hungry;

/**
 * @Auther: kai2.wang  饿汉单例模式
 * @Date: 2019/7/2 14:09
 * @Description:
 */
public class HungryStaticSingleton {

    public  static final HungryStaticSingleton hungryStaticSingleton;


    static{
        hungryStaticSingleton=new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}
