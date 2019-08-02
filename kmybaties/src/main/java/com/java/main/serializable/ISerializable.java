package com.java.main.serializable;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 18:13
 * @Description:
 */
public interface ISerializable {

    <T> byte[] serializable(T obj);

    <T> T deserializable(byte[] data);
}
