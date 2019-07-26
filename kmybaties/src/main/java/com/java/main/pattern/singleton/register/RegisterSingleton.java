package com.java.main.pattern.singleton.register;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/5 16:03
 * @Description:
 */
public enum  RegisterSingleton {

    INSTANCE;

    RegisterSingleton() {
    }

    public static RegisterSingleton getInstance(){
        return INSTANCE;
    }
}
