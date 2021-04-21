package cn.itcast.study.controller;

import cn.itcast.study.config.ConfigBean;
import cn.itcast.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @Title: UserController
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, cn.itcast.study.config.User.class})
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private Integer age;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private cn.itcast.study.config.User user;
    @Autowired
    private UserService userService;
    @RequestMapping("/getNameAndAge")
    public String getNameAndAge(){
        return name+"::::::"+age;
    }
   @RequestMapping("/getInfo")
    public String getInfo(){
        return configBean.getName()+":"+configBean.getAge()+":::"+configBean.getNumber();
    }
    @RequestMapping("/getUserInfo")
    public String getUserInfo(){
        return user.getName()+"****"+user.getAge();
    }
    @RequestMapping("/getUser/{name}")
    public cn.itcast.study.entity.User getUser(@PathVariable("name") String username){
        logger.info("getUser;username:{}",username);
       return userService.findByUsername(username);
    }
}
