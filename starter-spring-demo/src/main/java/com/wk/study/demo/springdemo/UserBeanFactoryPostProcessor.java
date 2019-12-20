package com.wk.study.demo.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @auther: kai2.wang
 * @date: 2019/12/20 15:36
 * @description:
 * @version: 1.0
 */
public class UserBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("---1111111--postProcessBeanFactory--------");
    }
}
