package com.study.rpc;

import java.io.Serializable;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 14:39
 * @description:
 * @version: 1.0
 */
public class User implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
