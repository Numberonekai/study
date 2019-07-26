package com.java.main.pattern.singleton.lazy;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/2 16:54
 * @Description:
 */
public class LazyDoubleCheckSingleton {

    public volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton=null;

    public static LazyDoubleCheckSingleton getInstance(){
        if(lazyDoubleCheckSingleton==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazyDoubleCheckSingleton==null){
                    lazyDoubleCheckSingleton=new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
