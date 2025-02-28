package com.example.adminserver.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.adminserver.log.LogExecutionTime;
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

    @Override
    public Map<String, Object> login(User user) {


        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);

        if (loginUser != null) {
            String key = "user:" + UUID.randomUUID();
            // 结果不为空，生成token，存入redis

            // return
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }

        return null;
    }

    @Override
    @LogExecutionTime
    public void test(){
//        int i = 1/0;
        System.out.println("Task performed！！！");
    }
}
