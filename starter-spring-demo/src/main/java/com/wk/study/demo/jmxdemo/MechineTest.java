package com.wk.study.demo.jmxdemo;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @auther: kai2.wang
 * @date: 2019/10/11 15:43
 * @description:
 * @version: 1.0
 */
public class MechineTest {

    public static void main(String[] args) {
        MBeanServer mBeanServer= ManagementFactory.getPlatformMBeanServer();
        ObjectName obj= null;
        try {
            obj = new ObjectName("com.wk.study.demo.jmxdemo:type=mechineImpl");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        MechineImpl mechine=new MechineImpl();
        try {
            mBeanServer.registerMBean(mechine,obj);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        }


    }
}
