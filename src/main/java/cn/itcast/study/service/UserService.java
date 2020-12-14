package cn.itcast.study.service;

import cn.itcast.study.entity.User;

/**
 * @author Administrator
 * @Title: UserService
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
public interface UserService {
    public User findByUsername(String username);
}
