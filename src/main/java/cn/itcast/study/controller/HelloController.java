package cn.itcast.study.controller;

import cn.itcast.study.dto.UserDto;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @Title: HelloController
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    private static AtomicInteger index = new AtomicInteger(0);
    @RequestMapping("/sayHello")
    @ResponseBody   //@Controller注解时一定要加否则访问404
    public String sayHello(){
        logger.info("测试日志输出");
        logger.info("nihao");
        int andIncrement = index.getAndIncrement();
        System.out.println(andIncrement);
        return "I miss you";
    }

    /*public static void main(String[] args) {
        Random randomid = new Random();
        List<String> strs = new ArrayList<>();
        strs.add("1111");
        strs.add("1112");
        strs.add("1113");
        System.out.println(strs.size());
        strs.forEach(s ->{
            System.out.println(s);
        });
        System.out.println("********************");
        strs.remove(0);
        System.out.println(strs.size());
        strs.forEach(s ->{
            System.out.println(s);
        });

    }*/
}
