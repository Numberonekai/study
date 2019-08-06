package com.study.rpc.server;

import com.study.rpc.IHelloService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @auther: kai2.wang
 * @date: 2019/8/6 09:14
 * @description:
 * @version: 1.0
 */
@Configurable
@ComponentScan("com.study.rpc.server")
public class SpringConfig {

    @Bean("rpcServer")
    public RpcServer getRpcServer(){
        return  new RpcServer(8080);
    }
}
