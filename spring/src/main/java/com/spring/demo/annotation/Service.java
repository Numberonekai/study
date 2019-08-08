package com.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:05
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Service {
    String value() default "";
}
