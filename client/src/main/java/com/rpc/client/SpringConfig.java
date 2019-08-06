package com.rpc.client;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @auther: kai2.wang
 * @date: 2019/8/6 11:53
 * @description:
 * @version: 1.0
 */
@Component
public class SpringConfig {

    @Bean("client")
    public Client getRpcClientProxy(){
        return new Client(8080,"localhost");
    }
}
