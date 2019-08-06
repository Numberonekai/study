package com.study.rpc.server;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @auther: kai2.wang
 * @date: 2019/8/6 09:08
 * @description:
 * @version: 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Server {

    Class<?> value();

    String version();
}
