package cn.itcast.study.mythread.demotest;

import cn.itcast.study.utils.ReturnResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginService {
    private static String name;
    private static String pass;
    private Logger logger = LoggerFactory.getLogger(LoginService.class);
    public synchronized ReturnResult doLogin(String username, String password){
        logger.info("doLogin;登录参数username:{};password:{}",username,password);
        ReturnResult returnResult = new ReturnResult();
        if(StringUtils.isAnyBlank(username,password)){
            returnResult.setCode(2001);
            returnResult.setMsg("参数为空");
            return returnResult;
        }
        name=username;

        try{
            if(username.equals("zhangsan")){
                Thread.sleep(5000);
            }
            pass=password;
            logger.info("doLogin;成员变量参数name:{};pass:{}",name,pass);
        }catch (Exception e){
            logger.info("doLogin;线程睡眠异常e:{}",e);
            returnResult.setCode(2002);
            returnResult.setMsg("线程睡眠异常");
            return returnResult;
        }
        returnResult.setCode(2000);
        returnResult.setMsg("成功");
        return returnResult;
    }
}
