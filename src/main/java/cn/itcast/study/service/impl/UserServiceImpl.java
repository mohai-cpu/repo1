package cn.itcast.study.service.impl;

import cn.itcast.study.dao.UserDao;
import cn.itcast.study.entity.User;
import cn.itcast.study.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @Title: UserServiceImpl
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }
    @Async("taskExecutor")
    @Override
    public User setMyUser() {
        User myuser = new User();
        myuser.setName("张三");
        myuser.setUsername("你好我在");
        for (int i = 0; i <500 ; i++) {
            System.out.println("***********************************");
        }
        logger.info("setMyUser;");
        return myuser;
    }
}
