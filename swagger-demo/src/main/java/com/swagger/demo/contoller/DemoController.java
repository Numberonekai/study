package com.swagger.demo.contoller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @auther: kai2.wang
 * @date: 2019/9/4 09:37
 * @description:
 * @version: 1.0
 */
@RestController
@Api(description = "用户管理接口")
public class DemoController {

    @GetMapping(value = "queryModel")
    @ApiOperation("查询用户")
    public String queryModel(@ApiParam(value = "模糊查询用户名") Integer pageNum, Integer pageSize, String name, String type, Date startTime, Date endTime) {
        return "123";
    }
}
