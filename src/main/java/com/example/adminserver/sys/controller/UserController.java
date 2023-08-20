package com.example.adminserver.sys.controller;

import com.example.adminserver.common.vo.Result;
import com.example.adminserver.sys.service.IUserService;
import com.example.adminserver.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Baci7
 * @since 2023-04-26
 */
@Controller
@RestController
@RequestMapping("/User")
// @CrossOrigin 处理跨域
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    public Result<List<User>> getAllUser() {
        List<User> list = userService.list();

        if (list.size() > 0) {
            return Result.success(list);

        } else {
            return Result.fail();
        }
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user) {

        Map<String,Object> data = userService.login(user);

        if (data != null) {
            return Result.success(data);
        } else {
            return Result.fail();
        }
    }


    @GetMapping("/info")
    public Result<Map<String, Object>> getUserInfo(@RequestParam("token") String token) {


        Map<String, Object> data = userService.getUserInfo(token);

        if (data != null) {
            return Result.success(data);
        } else {
            return Result.fail();
        }
    }


    @PostMapping("logout")
    public Result<?> logout(@RequestHeader("X-Token") String token) {
        userService.logout(token);

        return Result.success();
    }

}
