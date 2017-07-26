package com.example;

import com.example.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by daile on 2017/7/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));

        User user = new User(1l,"neeson",20);
        redisTemplate.opsForValue().set(user.getName(),user);

        Assert.assertEquals(20,redisTemplate.opsForValue().get("neeson").getAge().longValue());
    }
}
