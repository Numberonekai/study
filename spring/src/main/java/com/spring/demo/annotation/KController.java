package com.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:04
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface KController {

    String value() default "";
}
