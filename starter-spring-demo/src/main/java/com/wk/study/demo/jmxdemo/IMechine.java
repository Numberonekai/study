package com.wk.study.demo.jmxdemo;

/**
 * @auther: kai2.wang
 * @date: 2019/10/11 15:30
 * @description:
 * @version: 1.0
 */
public interface IMechine {

    long getFreeMemory();

    int getCpuCore();

    void shutDown();

}
