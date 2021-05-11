package cn.itcast.study.controller;

import cn.itcast.study.entity.User;
import cn.itcast.study.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Autowired
    private UserService userService;
    @RequestMapping("/sayHello")
    @ResponseBody   //@Controller注解时一定要加否则访问404
    public String sayHello(){
        logger.info("测试日志输出");
        int andIncrement = index.getAndIncrement();
        System.out.println(andIncrement);
        return "I miss you";
    }
    @RequestMapping("/testAsync")
    @ResponseBody
    public String testAsync(){
        for(int i=1;i<=20;){
            User user = userService.setMyUser();
            logger.info("testAsync;user:{}",JSONObject.toJSONString(user));
            logger.info("从今天起，努力代码每日500行");
            i+=5;
        }
        return "testAsync success";
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
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
