package com.java.main.pattern.proxy.jdkproxy.kproxy;

import com.java.main.pattern.proxy.jdkproxy.jdkproxy.Person;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 15:09
 * @description:
 * @version: 1.0
 */
public class KMeipo implements KInvocationHandler {
    private Person person;

    public Object getInstance(Person person) throws IOException {
        this.person=person;
        Class clazz=person.getClass();
        return KProxy.newProxyInstance(new KClassLoader(),clazz.getInterfaces(),this);
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
