package com.java.main.pattern.delegate;

/**
 *
 * 委派模式
 *
 * @Auther: kai2.wang
 * @Date: 2019/7/12 10:59
 * @Description:
 */
public class Boss {

    public void doing(String commond,Leader leader){
        leader.doing(commond);
    }
}
