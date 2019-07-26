package com.java.main.pattern.singleton.threadLocal;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/11 15:39
 * @Description:
 */
public class ThreadLocalSingleton {

    private static final  ThreadLocal<ThreadLocalSingleton> threadLocalSingletonThreadLocal=new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static  ThreadLocalSingleton getInstance(){
       return threadLocalSingletonThreadLocal.get();
    }
}
