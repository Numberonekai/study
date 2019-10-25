package com.java.main.pattern.proxy.jdkproxy.cglibproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @auther: kai2.wang
 * @date: 2019/10/24 18:00
 * @description:
 * @version: 1.0
 */
public class CGProxy implements MethodInterceptor {


    public Object getInstance(DemoClient demoClient) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(demoClient.getClass());

        return enhancer.create();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.getMethod().invoke(methodInvocation.getMethod().getClass());
        return null;
    }
}
