package cn.itcast.study.service.impl;

import cn.itcast.study.dao.UserDao;
import cn.itcast.study.entity.User;
import cn.itcast.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }
}
