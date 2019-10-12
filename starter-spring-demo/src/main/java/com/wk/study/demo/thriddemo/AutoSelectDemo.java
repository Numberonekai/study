package com.wk.study.demo.thriddemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 14:01
 * @description:
 * @version: 1.0
 */
public class AutoSelectDemo implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        annotationMetadata.getAnnotatedMethods(EnableService.class.getName());
        return new String[]{ThridService1.class.getName()};
    }
}
