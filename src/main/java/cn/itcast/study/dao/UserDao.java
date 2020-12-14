package cn.itcast.study.dao;

import cn.itcast.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Title: UserDao
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
public interface UserDao extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
