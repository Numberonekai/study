package com.spring.demo.annotation;

import java.lang.annotation.*;

/**
 * @Auther: kai2.wang
 * @Date: 2019/4/28 18:07
 * @Description:
 */
@Target(ElementType.PARAMETER)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {

    String value() default  "";
}
