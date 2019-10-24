package com.java.main.pattern.proxy.jdkproxy.jdkproxy;

import java.io.IOException;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/26 17:32
 * @Description:
 */
public class JdkProxyTest {

    public static void main(String[] args) throws IOException {

        Person person=(Person) (new Meipo( ).getInstance(new Gril()));
        person.findLove();
//
//        byte[] bytes=ProxyGenerator.generateProxyClass("$proxy0",new Class[]{Person.class});
//        FileOutputStream fileOutputStream=new FileOutputStream("E://test.class");
//        fileOutputStream.write(bytes);
//        fileOutputStream.flush();
//        fileOutputStream.close();;
    }
}
