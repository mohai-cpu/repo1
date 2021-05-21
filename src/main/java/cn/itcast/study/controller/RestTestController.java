package cn.itcast.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @Title: RestTestController
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/10/9
 */
@RestController
@RequestMapping("/rest")
public class RestTestController {
    private Logger logger = LoggerFactory.getLogger(RestTestController.class);
    @RequestMapping("/testRest")
    public String testRest() {
        RestTemplate restTemplate = new RestTemplate();
        String html = restTemplate.getForObject("https://www.baidu.com/", String.class);
        System.out.println(html);
        logger.info("testRest;html:{}",html);
        return html;
    }
    @RequestMapping(value = "/testCookie",method = RequestMethod.GET)
    public String testCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        StringBuilder sb = new StringBuilder();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                sb.append(cookie.getName()).append(",");
            }
        }
        return "testCookie:"+sb.toString();
    }
}
