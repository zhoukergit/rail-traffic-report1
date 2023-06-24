package com.example.statistic.service.impl;

import com.example.common.entity.R;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.statistic.entity.UserStatistic;
import com.example.statistic.mapper.UserStatisticMapper;
import com.example.statistic.service.UserStatisticService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.statistic.service.client.ServiceDetailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 操作员统计表 服务实现类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Service
public class UserStatisticServiceImpl extends ServiceImpl<UserStatisticMapper, UserStatistic> implements UserStatisticService {
    @Autowired
    ServiceDetailClient serviceDetailClient;

    @Override
    public boolean save(@Nullable String date) {
        if (!StringUtils.hasLength(date)) {
            date = LocalDate.now().toString();
        }
        //进行远程调用获取数据
        List<UserStatisticDto> userStatisticDtoList = serviceDetailClient.getUserStatisticDto(date).getData();

        //保存数据
        List<UserStatistic> userStatisticList = new ArrayList<>();
        int totalCount = 0; //总数
        int totalAmount = 0; //总金额
        UserStatistic userStatistic = null;
        //一条terminalNo代表一条记录
        for (UserStatisticDto dto : userStatisticDtoList) {
            //第一次使用需要初始化
            if (userStatistic == null) {
                userStatistic = new UserStatistic();
                userStatistic.setTerminalNo(dto.getTerminalNo());
                userStatistic.setOperateDate(LocalDate.parse(date));
                userStatistic.setUserId(dto.getUserId());
                //如果终端编号改变,需要创建一个新对象,并保存原对象到数组
            } else if (!userStatistic.getTerminalNo().equals(dto.getTerminalNo())) {
                userStatistic.setTotalAmount(totalAmount);
                userStatistic.setTotalCount(totalCount);
                userStatisticList.add(userStatistic);

                totalAmount = 0;
                totalCount = 0;
                userStatistic = new UserStatistic();
                userStatistic.setTerminalNo(dto.getTerminalNo());
                userStatistic.setOperateDate(LocalDate.parse(date));
                userStatistic.setUserId(dto.getUserId());
            }
            int amount = dto.getAmount();
            int count = dto.getCount();
            switch (dto.getDataType()) {
                case 1:
                    userStatistic.setSellAmount(amount);
                    userStatistic.setSellCount(count);
                    break;
                case 2:
                    userStatistic.setRefundAmount(amount);
                    userStatistic.setRefundCount(count);
                    break;
                case 3:
                    userStatistic.setTopUpAmount(amount);
                    userStatistic.setTopUpCount(count);
                    break;
                default:
                    continue;
            }
            //如果满足以上任意选项之一,计入总计
            totalAmount += amount;
            totalCount += count;
        }
        //把最后的userStatistic加到列表
        if (userStatistic != null) {
            userStatistic.setTotalCount(totalCount);
            userStatistic.setTotalAmount(totalAmount);
            userStatisticList.add(userStatistic);
        }

        this.saveBatch(userStatisticList);
        return true;
    }

}
