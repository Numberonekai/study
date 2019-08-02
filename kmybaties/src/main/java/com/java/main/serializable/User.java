package com.java.main.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/31 16:50
 * @Description:
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
}

