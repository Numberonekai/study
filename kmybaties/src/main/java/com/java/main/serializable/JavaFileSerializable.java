package com.java.main.serializable;

import java.io.*;
import java.nio.ByteBuffer;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 15:30
 * @Description:
 */
public class JavaFileSerializable implements ISerializable{

    @Override
    public <T> byte[] serializable(T obj) {
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("test")));
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deserializable(byte[] data) {
        try {
            ObjectInputStream  objectInputStream = new ObjectInputStream(new FileInputStream(new File("test")));
            return (T) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
