package com.study.rpc.server;

import com.study.rpc.IHelloService;
import com.study.rpc.User;

/**
 * @auther: kai2.wang
 * @date: 2019/8/5 14:43
 * @description:
 * @version: 1.0
 */
@Server(value = IHelloService.class,version = "1.0")
public class HelloServiceImpl implements IHelloService {


    @Override
    public User getUser(Integer id) {
        User user=new User();
        user.setId(1);
        user.setName("demo");
        return user;
    }
}
