package com.example.user.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.entity.GlobalException;
import com.example.common.entity.ResultCode;
import com.example.common.util.JwtUtils;
import com.example.user.entity.Admin;
import com.example.user.mapper.UcenterMemberMapper;
import com.example.user.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;


/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-03-15
 */
@Service
@Slf4j
public class UcenterMemberServiceImpl
        extends ServiceImpl<UcenterMemberMapper, Admin>
        implements UcenterMemberService {

    @Override
    public String login(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();

        //校验参数
        if (StringUtils.isEmpty(password) ||
                StringUtils.isEmpty(username)) {
            throw new GlobalException(ResultCode.INPUT_ERROR, "请检查输入!");
        }

        //获取会员
        Admin result = baseMapper.selectOne(new QueryWrapper<Admin>().eq("username", username));
        if (null == result) {
            throw new GlobalException(ResultCode.INPUT_ERROR, "用户不存在!");
        }


        //校验密码
        System.out.println(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (!DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()).equals(result.getPassword())) {
            throw new GlobalException(ResultCode.INPUT_ERROR, "密码错误!");
        }

        //使用JWT生成token字符串
        String token = JwtUtils.getJwtToken(result.getId().toString(), result.getUsername());
        return token;
    }
    

}
