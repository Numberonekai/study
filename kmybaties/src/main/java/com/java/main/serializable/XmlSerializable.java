package com.java.main.serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 18:46
 * @Description:
 */
public class  XmlSerializable implements ISerializable{

    XStream xStream=new XStream(new DomDriver());
    @Override
    public <T> byte[] serializable(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserializable(byte[] data) {
        return (T)xStream.fromXML(new String(data));
    }
}
