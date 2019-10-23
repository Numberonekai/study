package com.java.main.pattern.proxy.jdkproxy.demo2;

import com.java.main.pattern.proxy.jdkproxy.demo.Gril;
import com.java.main.pattern.proxy.jdkproxy.demo.Meipo;
import com.java.main.pattern.proxy.jdkproxy.demo.Person;

import java.io.IOException;

/**
 * @auther: kai2.wang
 * @date: 2019/10/23 15:18
 * @description:
 * @version: 1.0
 */
public class KTest {

    public static void main(String[] args) throws IOException {

        Person person=(Person) (new KMeipo().getInstance(new Gril()));
        person.findLove();
    }
}
