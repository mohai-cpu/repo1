package cn.itcast.study.controller;

import cn.itcast.study.entity.User;
import cn.itcast.study.utils.TokenUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
//@Valid User user,
@RestController
@RequestMapping("/mytoken")
public class TokenController {
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public String getTokenTest(HttpServletRequest request, HttpServletResponse response) {

        String token = TokenUtils.createToken();
        Cookie cookie = new Cookie("token", token);
        //设置cookie失效时间
        cookie.setMaxAge(10 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return token;
    }
}
