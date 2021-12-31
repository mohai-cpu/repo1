package cn.itcast.study.dao;

import cn.itcast.study.entity.MyUser;
import cn.itcast.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @Title: UserDao
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/28
 */
public interface MyUserDao extends JpaRepository<MyUser,Integer> {
}
