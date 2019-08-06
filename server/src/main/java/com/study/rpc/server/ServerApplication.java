package com.study.rpc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApplication {


    public static void main(String[] args) {

//        RpcServer rpcServer=new RpcServer(8080);
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext)applicationContext).start();
    }

}
