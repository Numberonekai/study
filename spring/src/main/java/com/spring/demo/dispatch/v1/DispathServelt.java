package com.spring.demo.dispatch.v1;

import com.spring.demo.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:08
 * @Description:
 */
public class DispathServelt extends HttpServlet {

    public Properties contextConfig = new Properties();

    public Map<String, Object> beanMap = new ConcurrentHashMap();

    public Map<String, Method> handlerMapping = new ConcurrentHashMap<>();

    private List<String> classNames = new ArrayList<String>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //定位
        doLoadConfig(config.getInitParameter("contextConfigLocation").replace("classpath:", ""));
        //加载
        doScanner(contextConfig.getProperty("scanPackage"));
        //注册
        doRegistry();
        //自动依赖注入
        doAutowired();
        //类加载路径
        initHandlerMapping();
        System.out.println("Spring Start :8080");

    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURI();
        String contentPath = request.getContextPath();
        String requestUrl = url.replaceAll(contentPath, "").replaceAll("/+", "/");
        System.out.println(requestUrl);

        if (this.handlerMapping.containsKey(requestUrl)) {
            Method method = handlerMapping.get(requestUrl);
            Map<String, String[]> params = request.getParameterMap();
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] objects=new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if (parameterType == HttpServletRequest.class) {
                    objects[i] = request;
                }else if(parameterType==HttpServletResponse.class){
                    objects[i] = response;
                }else{
                    Annotation[][] annotations=method.getParameterAnnotations();
                    parameterType.getAnnotation(KRequestParam.class);
                    for (int j = 0; j < annotations.length; j++) {
                        Annotation[] annotations1=annotations[j];
                        for(Annotation annotation:annotations1){
                            if(annotation.annotationType()==KRequestParam.class){
                                KRequestParam kRequestParam= (KRequestParam) annotation;
                                String param=kRequestParam.value();
                                if(params.containsKey(param)){
                                    if(i==j){
                                        String value= Arrays.toString(params.get(param)).replaceAll("\\[|\\]","");
                                        if(parameterType==Integer.class){
                                            objects[i]=Integer.parseInt(value);
                                        }else{
                                            objects[i]=value;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            KController claszz = method.getDeclaringClass().getAnnotation(KController.class);
            try {
                method.invoke(beanMap.get(claszz.value()), objects);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


    public void initHandlerMapping() {
        if (beanMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            if (!entry.getValue().getClass().isAnnotationPresent(KController.class)) {
                continue;
            }
            Method[] methods = entry.getValue().getClass().getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                if (!method.isAnnotationPresent(KRequestMapping.class)) {
                    continue;
                }
                String methodName = method.getAnnotation(KRequestMapping.class).value();
                handlerMapping.put("/" + entry.getValue().getClass().getAnnotation(KController.class).value() + "/" + methodName, method);
            }
        }


    }

    private void doAutowired() {
        if (beanMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            if (!entry.getValue().getClass().isAnnotationPresent(KController.class)) {
                continue;
            }
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(KResource.class)) {
                    field.setAccessible(true);
                    KResource resource = field.getAnnotation(KResource.class);
                    try {
                        field.set(entry.getValue(), beanMap.get(resource.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void doRegistry() {

        if (classNames.isEmpty()) {
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(KController.class)) {
                    KController beanName = clazz.getAnnotation(KController.class);
                    Object object = clazz.newInstance();
                    beanMap.put(beanName.value(), object);
                } else if (clazz.isAnnotationPresent(KService.class)) {
                    KService service = clazz.getAnnotation(KService.class);
                    Class<?>[] interferces = clazz.getInterfaces();
                    Object instantce = clazz.newInstance();
                    beanMap.put(service.value(), instantce);

                    for (Class<?> inteferce : interferces) {
                        beanMap.put(inteferce.getName(), instantce);
                    }

                } else {
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

        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));

        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                classNames.add(scanPackage + "." + file.getName().replace(".class", ""));
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
