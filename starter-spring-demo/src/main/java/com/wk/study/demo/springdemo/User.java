package com.wk.study.demo.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @auther: kai2.wang
 * @date: 2019/12/18 09:34
 * @description:
 * @version: 1.0
 */
public class User implements  BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, BeanPostProcessor, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("-----Start----");
    }

    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("-----setBeanFactory------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessBeforeInitialization------");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----postProcessAfterInitialization------");
        return null;
    }


    @PreDestroy
    public void end() {
        System.out.println("-----end----");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("-----setApplicationContext------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-----afterPropertiesSet------");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("-----setBeanName------");

    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        System.out.println("------BeanFactoryPostProcessor------");
//    }
}
