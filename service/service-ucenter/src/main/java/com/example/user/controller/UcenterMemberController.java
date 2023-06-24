package com.example.user.controller;


import com.example.common.entity.R;
import com.example.user.entity.Admin;
import com.example.user.service.UcenterMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/ucenter/")
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public R<String> login(@RequestBody Admin admin) {
        String token = memberService.login(admin);
        return R.success(token);
    }


}

