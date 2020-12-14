/*
package cn.itcast.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;

*/
/**
 * @author Administrator
 * @Title: RedisConfig
 * @ProjectName day02spring
 * @Description: TODO
 * @date 2020/9/29
 *//*

@Configuration
public class RedisConfig {
    @Autowired(required = false)
    private JedisConnectionFactory jedisConnectionFactory;
    @Bean
    public RedisTemplate<String,String> redisTemplate(@Qualifier("jedisConnectionFactory")RedisConnectionFactory factory){
        return new StringRedisTemplate(factory);
    }
    @Bean
    public ValueOperations<String,String> redisString(RedisTemplate<String,String> redisTemplate){
        return redisTemplate.opsForValue();
    }
    @Bean
    public ListOperations<String,String> redisList(RedisTemplate<String,String> redisTemplate){
        return redisTemplate.opsForList();
    }
    @Bean
    public SetOperations<String,String> redisSet(RedisTemplate<String,String> redisTemplate){
        return redisTemplate.opsForSet();
    }
    @Bean
    public ZSetOperations<String,String> redisZSet(RedisTemplate<String,String> redisTemplate){
        return redisTemplate.opsForZSet();
    }
    @Bean
    public HashOperations<String,String,String> redisHash(RedisTemplate<String,String> redisTemplate){
        return redisTemplate.opsForHash();
    }
}
*/
