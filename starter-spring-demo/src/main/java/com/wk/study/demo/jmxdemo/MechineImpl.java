package com.wk.study.demo.jmxdemo;

/**
 * @auther: kai2.wang
 * @date: 2019/10/11 15:41
 * @description:
 * @version: 1.0
 */
public class MechineImpl implements IMechine{
    @Override
    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    @Override
    public int getCpuCore() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public void shutDown() {
        System.exit(0);
    }
}
