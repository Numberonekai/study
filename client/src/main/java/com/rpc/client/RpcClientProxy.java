package com.rpc.client;

import com.study.rpc.RpcRequest;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 17:12
 * @description:
 * @version: 1.0
 */
public class RpcClientProxy implements InvocationHandler {

    private Integer port;
    private String host;

    public RpcClientProxy(Integer port, String host) {
        this.port = port;
        this.host = host;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        Socket socket= null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(host,port);
            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            RpcRequest rpcRequest=new RpcRequest();
            rpcRequest.setClassName(method.getDeclaringClass().getName());
            rpcRequest.setMethod(method.getName());
            rpcRequest.setParams(args);

            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();

            objectInputStream=new ObjectInputStream(socket.getInputStream());
            Object object=objectInputStream.readObject();
            System.out.println(object);
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
