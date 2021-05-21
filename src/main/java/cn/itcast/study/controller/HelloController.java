package cn.itcast.study.controller;

import cn.itcast.study.entity.User;
import cn.itcast.study.service.UserService;
import cn.itcast.study.utils.SignUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    private static AtomicInteger index = new AtomicInteger(0);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request,HttpServletResponse response){
        logger.info("测试日志输出");
        int andIncrement = index.getAndIncrement();
        System.out.println(andIncrement);
        Cookie cookie = new Cookie("lisi", "ydsadsa");
        cookie.setPath("/");
        //cookie.setSecure(true);//如果设置了Secure，则只有当使用https协议连接时cookie才可以被页面访问
        //cookie.setHttpOnly(true);//如果设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法访问该Cookie
        cookie.setDomain(".zhangsan.com");
       // cookie.setMaxAge(60);
        response.addCookie(cookie);
        return "springboot cookie test";
    }
    @RequestMapping(value = "/cookie01",method = RequestMethod.GET)
    public String cookie01(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        StringBuilder sb = new StringBuilder();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                sb.append(cookie.getName()).append(",");
            }
        }
       return "cookie01:"+sb.toString();
       /* String newLoginToken = getUUID();
        Cookie backcookie = new Cookie(cookiename, newLoginToken);
        backcookie.setHttpOnly(true);
        backcookie.setMaxAge(60 * 60 * 24);
        response.addCookie(backcookie);*/
        /* String uri = "";
       response.encodeRedirectURL(uri);
       response.encodeURL(uri);*/
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request){
       return "test is success";
    }

  /*  @RequestMapping("/testAsync")
  // @ResponseBody   //@Controller注解时一定要加否则访问404
    public String testAsync(){
        for(int i=1;i<=20;){
            User user = userService.setMyUser();
            logger.info("testAsync;user:{}",JSONObject.toJSONString(user));
            logger.info("**********************");
            i+=5;
        }
        return "testAsync success";
    }*/
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
        //System.out.println(Thread.currentThread().getName());
        //签名加密
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("agentid","123456");
        String secretKey = "dsafsafsdfffafsa";
        stringMap.put("secretKey",secretKey);
        Map<String, String> signMap = SignUtil.sign(stringMap);
        String mysign = signMap.get("sign");
        System.out.println(mysign);
    }
}
