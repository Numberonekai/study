package com.spring.demo.demo;

import com.spring.demo.Controller.DemoController;
import com.spring.demo.annotation.Controller;
import com.spring.demo.annotation.Resource;
import com.spring.demo.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:08
 * @Description:
 */
public class DispathServelt extends HttpServlet {

    public Properties contextConfig = new Properties();

    public Map<String,Object> beanMap = new ConcurrentHashMap();

    private List<String> classNames = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //定位
        doLoadConfig(config.getInitParameter("contextConfigLocation").replace("classpath:", ""));
        System.out.println(contextConfig);

        //加载
        doScanner(contextConfig.getProperty("scanPackage"));

        //注册
        doRegistry();

        //自动依赖注入
        doAutowired();

        DemoController demoController2=(DemoController) beanMap.get("DemoController");
        System.out.println(demoController2.queryResult("王凯"));
    }

    private void doAutowired() {
        if(beanMap.isEmpty()){
            return;
        }

        for(Map.Entry<String,Object> entry:beanMap.entrySet()){
                Field[] fields=entry.getValue().getClass().getDeclaredFields();
                for (Field field:fields){
                    if(field.isAnnotationPresent(Resource.class)){
                       field.setAccessible(true);
                        Resource resource=field.getAnnotation(Resource.class);
                        try {
                            field.set(entry.getValue(),beanMap.get(resource.value()));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }

    }

    private void doRegistry() {

        if(classNames.isEmpty()){
            return;
        }

        for (String className:classNames){
            try {
                Class<?> clazz=Class.forName(className);
                if(clazz.isAnnotationPresent(Controller.class)){
                    String beanName=clazz.getSimpleName();
                    beanMap.put(beanName,clazz.newInstance());
                }else if(clazz.isAnnotationPresent(Service.class)){
                   Service service=clazz.getAnnotation(Service.class);
                   Class<?>[] interferces=clazz.getInterfaces();
                   Object instantce=clazz.newInstance();
                    beanMap.put(service.value(),instantce);

                    for (Class<?> inteferce:interferces){
                       beanMap.put(inteferce.getName(),instantce);
                   }

                }else{
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }


    }

    private void doScanner(String scanPackage) {

        URL url = this.getClass().getClassLoader().getResource("/"+scanPackage.replaceAll("\\.","/"));

        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                classNames.add(scanPackage + "." + file.getName().replace(".class",""));
            }
        }
    }

    private void doLoadConfig(String location) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(location);

        try {
            contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
