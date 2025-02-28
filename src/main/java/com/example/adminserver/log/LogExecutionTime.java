package com.example.adminserver.log;


import java.lang.annotation.*;

// 标记在方法上
@Target(ElementType.METHOD)
// 注解在运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface LogExecutionTime {
}
