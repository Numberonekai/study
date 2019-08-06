package com.study.rpc.server;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 14:33
 * @description:
 * @version: 1.0
 */
public class RpcServer implements ApplicationContextAware, InitializingBean {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private Map serverMap=new HashMap();

    private Integer port;
    public RpcServer(int port) {
     this.port=port;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessHandler(socket,serverMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beanMap=applicationContext.getBeansWithAnnotation(Server.class);
        if(beanMap!=null){
           for (Object bean:beanMap.values()){
               Server server=bean.getClass().getAnnotation(Server.class);
               String serverName=server.value().getName();
               serverMap.put(serverName,bean);
           }
        }
    }
}
