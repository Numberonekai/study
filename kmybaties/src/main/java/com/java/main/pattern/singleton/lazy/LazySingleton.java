package com.java.main.pattern.singleton.lazy;

/**
 *
 * 注册时单例
 * @Auther: kai2.wang
 * @Date: 2019/7/2 14:06
 * @Description:
 */
public class LazySingleton {

    public static  LazySingleton lazySingleton = null;

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
