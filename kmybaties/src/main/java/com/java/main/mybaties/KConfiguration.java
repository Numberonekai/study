package com.java.main.mybaties;

import java.lang.reflect.Proxy;

/**
 * @Auther: kai2.wang
 * @Date: 2019/6/26 10:07
 * @Description:
 */
public class KConfiguration {



    public <T> T getMapper(Class classzz,SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{classzz},new KMapperProxy(sqlSession));
    }
}
