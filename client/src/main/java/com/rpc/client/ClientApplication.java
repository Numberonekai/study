package com.rpc.client;

import com.study.rpc.IHelloService;
import com.study.rpc.User;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.net.Socket;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 17:02
 * @description:
 * @version: 1.0
 */
public class ClientApplication {

    public static void main(String[] args) {

//        Client client=new Client(8080,"localhost");
//        IHelloService iHelloService=client.receiveData(IHelloService.class);
//        User user=iHelloService.getUser(1);
//        System.out.println("result"+user);
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        Client client= (Client) applicationContext.getBean("client");
        IHelloService iHelloService=client.receiveData(IHelloService.class);
        User user=iHelloService.getUser(1);

    }
}
