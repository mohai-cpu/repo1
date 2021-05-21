package cn.itcast.study.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/share")
public class ShareSessionController {
    @RequestMapping(value = "/createSession",method = RequestMethod.GET)
    public String createSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("share","share session");
        //session.removeAttribute();
        Cookie sessioncookie01 = new Cookie("sessioncookie01", session.getId());
        sessioncookie01.setPath("/");
        //sessioncookie01.setDomain(".zhangsan.com");
        //sessioncookie01.setMaxAge(60);
        //session.invalidate();//使session失效
        return "createSession test";
    }
    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public String getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        if(session != null){
            Object username = session.getAttribute("share");
            return "share="+JSONObject.toJSONString(username);
        }else{
            return "no session";
        }
    }
}
