package com.example.statistic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.statistic.entity.UserStatistic;
import com.example.statistic.entity.query.UserStatisticQuery;
import com.example.statistic.service.UserStatisticService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 操作员统计表 前端控制器
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@RestController
@RequestMapping("user-statistic")
public class UserStatisticController {
    @Autowired
    UserStatisticService userStatisticService;
    @PostMapping("page/{current}/size/{size}")
    List<UserStatistic> list(@PathVariable int current, @PathVariable int size, @RequestBody(required = false) UserStatisticQuery query){
        Page<UserStatistic> page = new Page<>(current,size);
        QueryWrapper<UserStatistic> wrapper =null;
        if (query != null){
            wrapper = new QueryWrapper<>();
            wrapper.ge(query.getStartTime()!=null,"operate_date",query.getStartTime());
            wrapper.le(query.getEndTime()!=null,"operate_date",query.getEndTime());
            wrapper.eq(query.getUserId()!=null,"user_id",query.getUserId());
            wrapper.eq(query.getTerminalNo()!=null,"terminal_no",query.getTerminalNo());
        }
        userStatisticService.page(page,wrapper);
        return page.getRecords();
    }
}
