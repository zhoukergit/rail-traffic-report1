package com.example.user.service;

import com.example.user.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2022-03-15
 */
public interface UcenterMemberService extends IService<Admin> {
    String login(Admin admin);
}
