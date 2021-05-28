package cn.itcast.study.mythread.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
   /* @RequestMapping(value = "/doLogin",method = RequestMethod.GET)
    public ReturnResult doLogin(String username,String password){
        logger.info("doLogin;登录参数username:{};password:{}",username,password);
        ReturnResult returnResult = new ReturnResult();
        if(StringUtils.isAnyBlank(username,password)){
            returnResult.setCode(2001);
            returnResult.setMsg("参数为空");
            return returnResult;
        }
        try{
           if(username.equals("zhangsan")){
                Thread.sleep(5000);
           }
        }catch (Exception e){
            logger.info("doLogin;线程睡眠异常e:{}",e);
            returnResult.setCode(2002);
            returnResult.setMsg("线程睡眠异常");
            return returnResult;
        }
        return null;
    }*/
}
