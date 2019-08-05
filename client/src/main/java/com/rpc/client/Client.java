package com.rpc.client;

import java.lang.reflect.Proxy;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 15:52
 * @description:
 * @version: 1.0
 */
public class Client {

    private Integer port;
    private String host;

    public Client(Integer port, String host) {
        this.port = port;
        this.host = host;
    }

    public <T> T receiveData(final Class<T> clazz) {
       return  (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz},new RpcClientProxy(port,host));
    }

}
