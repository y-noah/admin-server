package com.example.adminserver.sys.service;

import com.example.adminserver.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Baci7
 * @since 2023-04-26
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);

    void test();

}
