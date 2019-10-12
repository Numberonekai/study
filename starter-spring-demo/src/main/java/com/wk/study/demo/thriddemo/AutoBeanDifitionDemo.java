package com.wk.study.demo.thriddemo;

import com.wk.study.demo.seconddemo.current.TestService;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 14:02
 * @description:
 * @version: 1.0
 */
public class AutoBeanDifitionDemo implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(ThridService2.class);
        String beanName= StringUtils.uncapitalize(ThridService2.class.getName());
        beanDefinitionRegistry.registerBeanDefinition(beanName,rootBeanDefinition);
    }
}
