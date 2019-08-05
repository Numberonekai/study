package com.study.rpc;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 15:09
 * @description:
 * @version: 1.0
 */
@Data
public class RpcRequest implements Serializable {

    private String method;
    private String className;
    private Object[] params;

}
