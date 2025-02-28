package com.example.adminserver.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Baci7
 * @since 2023-04-26
 */

@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Integer status;

    private String avatar;

    private Integer deleted;
}
