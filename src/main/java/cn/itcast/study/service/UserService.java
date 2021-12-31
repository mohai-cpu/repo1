package cn.itcast.study.service;

import cn.itcast.study.dto.UserDto;
import cn.itcast.study.entity.User;
import cn.itcast.study.utils.ReturnResult;

/**
 * @author Administrator
 * @Title: UserService
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
public interface UserService {
    public User findByUsername(String username);
    public User setMyUser();
    public ReturnResult saveUser();
}
