package com.study.rpc.server;

import com.study.rpc.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 15:03
 * @description:
 * @version: 1.0
 */
public class ProcessHandler implements Runnable{

    private Socket socket;

    public ProcessHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            objectInputStream=new ObjectInputStream(socket.getInputStream());

            RpcRequest rpcRequest=(RpcRequest)objectInputStream.readObject();
            Object result=invoke(rpcRequest);
            System.out.println(result+"------server------");

            objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
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
    }

    private Object invoke(RpcRequest request) {
        Class tClass= null;
        try {
            tClass = Class.forName(request.getClassName());
            Object[]  params=request.getParams();
            Class<?>[] type=new Class<?>[params.length];
            for (int i = 0; i < params.length; i++) {
                type[i]=params[i].getClass();
            }
            Method method=tClass.getMethod(request.getMethod(),type);
            return method.invoke(HelloServiceImpl.class.newInstance(),params);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
