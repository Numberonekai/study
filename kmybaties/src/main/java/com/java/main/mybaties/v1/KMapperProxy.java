package com.java.main.mybaties.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

/**
 * @Auther: kai2.wang
 * @Date: 2019/6/26 10:08
 * @Description:
 */
public class KMapperProxy implements InvocationHandler {


    public  final static ResourceBundle sqlMappings;

    static{
        sqlMappings=ResourceBundle.getBundle("sql");
    }

    private SqlSession sqlSession;

    public KMapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String statmentId=method.getDeclaringClass().getName()+"."+method.getName();
        return sqlSession.selectOne(sqlMappings.getString(statmentId),args[0]);
    }
}
