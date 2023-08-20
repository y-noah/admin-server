package com.example.adminserver.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.adminserver.sys.entity.User;
import com.example.adminserver.sys.mapper.UserMapper;
import com.example.adminserver.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Baci7
 * @since 2023-04-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(User user) {


        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);

        if (loginUser != null) {
            String key = "user:" + UUID.randomUUID();
            // 结果不为空，生成token，存入redis
            loginUser.setPassword(null);
            redisTemplate.opsForValue().set(key,loginUser, 30, TimeUnit.MINUTES);

            // return
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }

        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {

        Object obj = redisTemplate.opsForValue().get(token);

        System.out.println("obj:" + obj);

        if (obj != null) {
            User loginUser = JSON.parseObject(JSON.toJSONString(obj), User.class);
            HashMap<String, Object> data = new HashMap<>();
            data.put("name", loginUser.getUsername());
            data.put("avatar", loginUser.getAvatar());
            System.out.println("data:" + data);
            // 0data.put("")
            return data;
        }

        return null;
    }

    @Override
    public void logout(String token) {

        redisTemplate.delete(token);
    }
}
