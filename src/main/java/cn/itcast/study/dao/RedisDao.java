package cn.itcast.study.dao;

import cn.itcast.study.constant.RedisKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @Title: RedisDao
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/29
 */
@Repository
public class RedisDao {
   /* @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private ValueOperations<String,String> valueOperations;
    @Autowired
    private ListOperations<String,String> listOperations;
    @Autowired
    private SetOperations<String,String> setOperations;
    @Autowired
    private ZSetOperations<String,String> zSetOperations;
    @Autowired
    private HashOperations<String,String,String> hashOperations;*/
    @Autowired
    private StringRedisTemplate template;
    public void addList(){
        //template.opsForValue().set(RedisKey.USER_KEY1,"11",10);
        template.opsForValue().increment(RedisKey.USER_KEY1,5);
        template.opsForValue().increment(RedisKey.USER_KEY2,10);
        String s = template.opsForValue().get(RedisKey.USER_KEY1);
        String s1 = template.opsForValue().get(RedisKey.USER_KEY2);
        System.out.println(s+"***********************************************");
        System.out.println(s1+"=88888888888888888888**");
//        template.opsForList().leftPush(RedisKey.NAMELIST,"罗琴");
//        template.opsForList().leftPush(RedisKey.NAMELIST,"张三");
//        template.opsForHash().put(RedisKey.USER_HASH,"123","lisi");
//        template.opsForHash().put(RedisKey.USER_HASH,"124","liwu");
    }
}
