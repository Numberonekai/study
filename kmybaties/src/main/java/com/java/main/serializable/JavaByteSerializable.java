package com.java.main.serializable;

import java.io.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 18:39
 * @Description:
 */
public class JavaByteSerializable implements ISerializable{
    @Override
    public <T> byte[] serializable(T obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserializable(byte[] data) {
        ObjectInputStream objectInputStream= null;
        try {
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (T) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
