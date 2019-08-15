package com.spring.demo.Controller;


import com.spring.demo.annotation.KController;
import com.spring.demo.annotation.KRequestMapping;
import com.spring.demo.annotation.KRequestParam;
import com.spring.demo.annotation.KResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:15
 * @Description:
 */
@KController("dispatch")
public class DemoController {

    @KResource("demoService")
    public DemoService demoService;

    @KRequestMapping("test")
    public String queryResult(HttpServletRequest request, HttpServletResponse response, @KRequestParam("name") String name,@KRequestParam("id")Integer id){
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getOutputStream().write(("This is my"+name+"--id--"+id).getBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return demoService.getData()+name;
    }

    @KRequestMapping("test1")
    public String queryResult1(HttpServletRequest request, HttpServletResponse response, @KRequestParam("name") String name){
        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getOutputStream().write((demoService.getData()+name).getBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return demoService.getData()+name;
    }
}
