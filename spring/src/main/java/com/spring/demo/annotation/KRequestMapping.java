package com.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:17
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KRequestMapping {

    String value() default "";
}
