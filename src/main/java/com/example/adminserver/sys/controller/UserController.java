package com.example.adminserver.sys.controller;

import com.example.adminserver.common.vo.Result;
import com.example.adminserver.sys.service.IUserService;
import com.example.adminserver.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/login")
    public Result<Map<String,Object>> login(User user) {
        Map<String, Object> data = userService.login(user);

        if (data!=null) {
            return Result.success(data);
        } else {
            return Result.fail();
        }
    }


    @GetMapping("/select")
    public Result<Map<String,Object>> select() {
        return Result.success();
    }


    @GetMapping("/test")
    public Result<Map<String,Object>> test(){
        userService.test();
        return Result.success();
    }

}
