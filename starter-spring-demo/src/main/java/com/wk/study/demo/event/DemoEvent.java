package com.wk.study.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @auther: kai2.wang
 * @date: 2019/12/17 15:10
 * @description:
 * @version: 1.0
 */
public class DemoEvent extends ApplicationEvent {


    private String msg;

    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
