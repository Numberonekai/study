package com.wk.study.demo.five;

import com.spring.spi.FormatTempleate;
import com.spring.spi.annotiation.AutoConfiguration;
import com.spring.spi.annotiation.FormConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: kai2.wang
 * @date: 2019/10/11 09:00
 * @description:
 * @version: 1.0
 */
@RestController
public class FiveTest {

//    @Autowired
//    private FormConfig formConfig;
//
//    @GetMapping("five")
//    public String getResult(){
//        UserInfo userInfo=new UserInfo();
//        userInfo.setId(1);
//        userInfo.setName("Wk");
//        userInfo.setAddress("望京");
//        return "five"+formConfig.jsonFormat().formatData(userInfo);
//    }

    @Autowired
    private FormatTempleate formatTempleate;

    @GetMapping("five")
    public String getResult(){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        userInfo.setName("Wk");
        userInfo.setAddress("望京");
        return "five"+formatTempleate.format(userInfo);
    }
}
