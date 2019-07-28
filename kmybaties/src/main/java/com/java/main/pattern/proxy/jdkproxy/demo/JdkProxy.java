package com.java.main.pattern.proxy.jdkproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/26 09:35
 * @Description:
 */
public class JdkProxy implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person){
        this.person=person;
        Class clazz=person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         Object result=method.invoke(this.person,args);
        after();
        return result;
    }

    public void before(){
        System.out.println("开始之前");
    }

    public void after(){
        System.out.println("结束之后");
    }
}
