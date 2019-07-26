package com.java.main;

import com.java.main.pattern.singleton.lazy.LazyInnerSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/5 15:33
 * @Description:
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {

        Class tClass= LazyInnerSingleton.class;

        try {
            Constructor constructor=tClass.getDeclaredConstructor(null);
            constructor.setAccessible(true);

            Object o1=constructor.newInstance();

            Object o2=LazyInnerSingleton.getInstance();

            System.out.println(o1+"---"+o2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
