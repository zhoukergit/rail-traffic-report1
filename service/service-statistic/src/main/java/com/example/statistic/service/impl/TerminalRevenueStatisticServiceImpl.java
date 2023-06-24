package com.example.statistic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.entity.R;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.statistic.entity.BaseCardRevenue;
import com.example.statistic.entity.TerminalRevenueStatistic;
import com.example.statistic.entity.bo.TerminalRevenueBo;
import com.example.statistic.entity.dto.BOMRevenueDto;
import com.example.statistic.entity.dto.TVMRevenueDto;
import com.example.statistic.entity.query.TerminalRevenueStatisticQuery;
import com.example.statistic.mapper.TerminalRevenueStatisticMapper;
import com.example.statistic.service.TerminalRevenueStatisticService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.statistic.service.client.ServiceDetailClient;
import freemarker.template.utility.NormalizeNewlines;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouke
 * @since 2022-05-04
 */
@Service
@Slf4j
public class TerminalRevenueStatisticServiceImpl extends ServiceImpl<TerminalRevenueStatisticMapper, TerminalRevenueStatistic> implements TerminalRevenueStatisticService {
    @Autowired
    ServiceDetailClient serviceDetailClient;

    @Override
    public void saveTerminalRevenueStatistic(String date) {
        R<List<TerminalRevenueDto>> resBody = serviceDetailClient.getTerminalRevenueDto(date);
        List<TerminalRevenueDto> dtos = resBody.getData();
        List<TerminalRevenueStatistic> statistics = dtos.stream().map(
                dto -> {
                    TerminalRevenueStatistic statistic = new TerminalRevenueStatistic();
                    //数据交代不名,线路只能写死
                    BeanUtils.copyProperties(dto, statistic);
                    statistic.setLine(4);
                    return statistic;
                }
        ).collect(Collectors.toList());
        this.saveBatch(statistics);
    }

    @Override
    public List<BOMRevenueDto> getBOMRevenueStatistics(Integer transType, TerminalRevenueStatisticQuery query) {
        QueryWrapper<TerminalRevenueBo> wrapper = new QueryWrapper<>();
        wrapper.likeRight(query.getTerminalNo() == null, "terminal_no", "B00")
                .eq(query.getTerminalNo() != null, "terminal_no", query.getTerminalNo())
                .ge(query.getStartTime() != null, "date", query.getStartTime())
                .le(query.getEndTime() != null, "date", query.getEndTime())
                .eq("trans_type", transType);
        ;
        List<TerminalRevenueBo> bos = baseMapper.selectTerminalRevenueStatistic(1, transType, wrapper);
        List<BOMRevenueDto> dtos = new ArrayList<>();
        BOMRevenueDto dto = new BOMRevenueDto();
        int total = 0;
        for (TerminalRevenueBo bo : bos) {
            if (!bo.getTerminalNo().equals(dto.getTerminalNo())) {
                dto.setTotal(total);
                dto = new BOMRevenueDto();
                dtos.add(dto);
                total = 0;
                dto.setTerminalNo(bo.getTerminalNo());
            }
            BaseCardRevenue baseCardRevenue = new BaseCardRevenue();
            BeanUtils.copyProperties(bo, baseCardRevenue);
            total += bo.getTotal();
            switch (bo.getCardType()) {
                case "储值票":
                    dto.setStoredCardRevenue(baseCardRevenue);
                    break;
                case "爱心卡":
                    dto.setLoveCardRevenue(baseCardRevenue);
                    break;
                case "普通卡":
                    dto.setNormalCardRevenue(baseCardRevenue);
                    break;
                case "学生卡":
                    dto.setStudentCardRevenue(baseCardRevenue);
                    break;
                default:
                    break;
            }
        }
        dto.setTotal(total);

        return dtos;
    }

    @Override
    public List<TVMRevenueDto> getTVMRevenueStatistics(Integer transType, TerminalRevenueStatisticQuery query) {
        QueryWrapper<TerminalRevenueBo> wrapper = new QueryWrapper<>();
        wrapper.likeRight(query.getTerminalNo() == null, "terminal_no", "0401")
                .eq(query.getTerminalNo() != null, "terminal_no", query.getTerminalNo())
                .ge(query.getStartTime() != null, "date", query.getStartTime())
                .le(query.getEndTime() != null, "date", query.getEndTime())
                .eq("trans_type", transType);
        List<TerminalRevenueBo> bos = baseMapper.selectTerminalRevenueStatistic(1, transType, wrapper);
        List<TVMRevenueDto> dtos = new ArrayList<>();
        TVMRevenueDto dto = new TVMRevenueDto();
        int total = 0;
        for (TerminalRevenueBo bo : bos) {
            if (!bo.getTerminalNo().equals(dto.getTerminalNo())) {
                dto.setTotal(total);
                dto = new TVMRevenueDto();
                dto.setTerminalNo(bo.getTerminalNo());
                dto.setLine(bo.getLine());
                dto.setStation(bo.getStation());
                total = 0;
                dtos.add(dto);
            } else {
                total += bo.getTotal();
                switch (bo.getCardType()) {
                    case "储值卡":
                        //储值卡包括BOM和TVM两种
                        dto.setStoreSellCount(bo.getSellCount());
                        dto.setStoreSellDeposit(bo.getSellDeposit());
                        dto.setStoreTopUpAmount(bo.getTopUpAmount());
                        dto.setStoreTopUpCount(bo.getTopUpCount());
                        break;
                    case "爱心卡":
                        dto.setLoveTopUpCount(bo.getTopUpCount());
                        dto.setLoveTopUpAmount(bo.getTopUpAmount());
                        break;
                    case "普通卡":
                        dto.setNormalTopUpAmount(bo.getTopUpCount());
                        dto.setNormalTopUpCount(bo.getTopUpAmount());
                    case "学生卡":
                        dto.setStudentTopUpAmount(bo.getTopUpAmount());
                        dto.setStudentTopUpCount(bo.getTopUpCount());
                        break;
                    default:
                        break;
                }
            }
        }
        dto.setTotal(total);
        return dtos;
    }

}
