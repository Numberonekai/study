package com.java.main.pattern.singleton.lazy;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/5 15:27
 * @Description:
 */
public class LazyInnerSingleton {

    public LazyInnerSingleton(){
        if(LazyHolder.lazyInnerSingleton!=null){
            throw new RuntimeException("Error ---------");
        }
    }

    public static final LazyInnerSingleton  getInstance(){
        return LazyHolder.lazyInnerSingleton;
    }

    private static class LazyHolder{
        private static final LazyInnerSingleton lazyInnerSingleton=new LazyInnerSingleton();
    }
}
