package com.example.statistic.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.statistic.entity.CardIssueStatistic;
import com.example.statistic.entity.UserStatistic;
import com.example.statistic.entity.query.UserStatisticQuery;
import com.example.statistic.entity.vo.CardIssueVo;
import com.example.statistic.service.CardIssueStatisticService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@RestController
@RequestMapping("card-issue")
public class CardIssueStatisticController {
    @Autowired
    CardIssueStatisticService cardIssueStatisticService;

    @PostMapping("page/{current}/size/{size}")
    List<CardIssueStatistic> list(@PathVariable int current, @PathVariable int size, @RequestBody(required = false) UserStatisticQuery query) {
        Page<CardIssueStatistic> page = new Page<>(current, size);
        QueryWrapper<CardIssueStatistic> wrapper = null;

        if (query != null) {
            wrapper = new QueryWrapper<>();
            wrapper.ge(query.getStartTime() != null, "date", query.getStartTime());
            wrapper.le(query.getEndTime() != null, "date", query.getEndTime());
        }
        cardIssueStatisticService.page(page, wrapper);
//        page.getRecords().stream().map(
//                bo -> {
//                    CardIssueVo vo = new CardIssueVo();
//                        vo.setBOMCardCount(bo.getStoreCardCount()/7*3);
//                        vo.setTVMCardCount(bo.getStoreCardCount()/7*4);
//                        return vo;
//                }
//        );
        return page.getRecords();
    }
}
