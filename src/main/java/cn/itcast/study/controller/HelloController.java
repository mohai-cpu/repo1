package cn.itcast.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Title: HelloController
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/sayHello")
    public String sayHello(){
        return "I miss you luo qing";
    }
}
