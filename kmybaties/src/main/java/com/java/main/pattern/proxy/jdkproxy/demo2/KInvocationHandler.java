package com.java.main.pattern.proxy.jdkproxy.demo2;

import java.lang.reflect.Method;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 14:57
 * @description:
 * @version: 1.0
 */
public interface KInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
