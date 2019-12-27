package com.wk.study.demo.springdemo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther: kai2.wang
 * @date: 2019/12/27 14:53
 * @description:
 * @version: 1.0
 */
@Configuration
public class DemoImportBeanDeinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        System.out.println("-----registerBeanDefinitions------");
    }
}
