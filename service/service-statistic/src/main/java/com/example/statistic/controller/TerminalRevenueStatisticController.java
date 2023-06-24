package com.example.statistic.controller;


import com.example.statistic.entity.dto.BOMRevenueDto;
import com.example.statistic.entity.dto.TVMRevenueDto;
import com.example.statistic.entity.query.TerminalRevenueStatisticQuery;
import com.example.statistic.service.TerminalRevenueStatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/revenue")
@Api("获取设备营收报表")
public class TerminalRevenueStatisticController {
    @Autowired
    TerminalRevenueStatisticService terminalRevenueStatisticService;

    @ApiOperation("TVM营收日报表-现金")
    @PostMapping("/tvm-cash")
    public List<TVMRevenueDto> getTvmCash(@RequestBody(required = false) TerminalRevenueStatisticQuery query) {
        return terminalRevenueStatisticService.getTVMRevenueStatistics(1, query);
    }

    @ApiOperation("TVM营收日报表-电子支付")
    @PostMapping("/tvm-electronic")
    public List<TVMRevenueDto> getTvmElectronic(@RequestBody(required = false) TerminalRevenueStatisticQuery query) {
        return terminalRevenueStatisticService.getTVMRevenueStatistics(2, query);
    }


    @ApiOperation("BOM营收日报表-现金")
    @PostMapping("/bom-cash")
    public List<BOMRevenueDto> getBOMCash(@RequestBody(required = false) TerminalRevenueStatisticQuery query) {
        return terminalRevenueStatisticService.getBOMRevenueStatistics(1, query);
    }

    @ApiOperation("BOM营收日报表-电子支付")
    @PostMapping("/bom-electronic")
    public List<BOMRevenueDto> getBOMElectronic(@RequestBody(required = false) TerminalRevenueStatisticQuery query) {
        return terminalRevenueStatisticService.getBOMRevenueStatistics(2, query);
    }

}
