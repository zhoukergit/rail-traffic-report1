package com.example.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * com.example.educenter.entity
 *
 * @author zhouke
 * 2022/5/17
 * 11:06
 */
@TableName("admin")
@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private String append;
}
