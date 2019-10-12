package com.wk.study.demo.thriddemo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @auther: kai2.wang
 * @date: 2019/10/10 14:05
 * @description:
 * @version: 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({AutoSelectDemo.class,AutoBeanDifitionDemo.class})
public @interface EnableService {
}
