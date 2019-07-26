package com.java.main.pattern.delegate;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/12 11:01
 * @Description:
 */
public class EmployerA implements  IEmployer{

    @Override
    public void doing() {
        System.out.println("I can do java work");
    }
}
