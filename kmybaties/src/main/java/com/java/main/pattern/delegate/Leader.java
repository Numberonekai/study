package com.java.main.pattern.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: kai2.wang
 * @Date: 2019/7/12 10:59
 * @Description:
 */
public class Leader{

    private Map<String,IEmployer> employerMap=new HashMap<String,IEmployer>();

    public Leader() {
        employerMap.put("java",new EmployerA());
        employerMap.put("node",new EmployerB());
    }

    public void doing(String commond) {
        employerMap.get(commond).doing();
    }
}
