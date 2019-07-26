package com.java.main.pattern.proxy.jdkproxy.demo;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/26 17:32
 * @Description:
 */
public class JdkProxyTest {

    public static void main(String[] args) {

        Person person=(Person) (new JdkProxy().getInstance(new Gril()));
        person.findLove();
    }
}
