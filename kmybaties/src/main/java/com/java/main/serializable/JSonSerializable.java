package com.java.main.serializable;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

/**
 * @Auther: kai2.wang
 * @Date: 2019/8/1 18:54
 * @Description:
 */
public class JSonSerializable implements ISerializable {
    @Override
    public <T> byte[] serializable(T obj) {
        return JSONObject.toJSON(obj).toString().getBytes();
    }

    @Override
    public <T> T  deserializable(byte[] data) {
        return (T)JSONObject.parseObject(new String(data),User.class);
    }
}
