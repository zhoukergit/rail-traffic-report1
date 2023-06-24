import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.statistic.StatisticApplication;
import com.example.statistic.entity.UserStatistic;
import com.example.statistic.service.CardIssueStatisticService;
import com.example.statistic.service.TerminalRevenueStatisticService;
import com.example.statistic.service.TotalRevenueStatisticService;
import com.example.statistic.service.UserStatisticService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/5
 * 20:08
 */
@SpringBootTest(classes = StatisticApplication.class)
@Slf4j
public class ServiceTest {
    @Autowired
    UserStatisticService userStatisticService;

    @Autowired
    CardIssueStatisticService cardIssueStatisticService;

    @Autowired
    TerminalRevenueStatisticService terminalRevenueStatisticService;

    @Autowired
    TotalRevenueStatisticService totalRevenueStatisticService;
    LocalDate startDate = LocalDate.of(2022, 5, 1);

    @Test
//    @Transactional
    public void saveBatch() {
        for (int i = 0; i < 29; i++) {
            try {
                cardIssueStatisticService.saveCardIssueStatistics(startDate.toString());
//                userStatisticService.save(startDate.toString());
//                terminalRevenueStatisticService.saveTerminalRevenueStatistic(startDate.toString());
//                totalRevenueStatisticService.saveTotalRevenueStatistic(startDate.toString());
                startDate = startDate.plusDays(1);
            } catch (Exception e) {
                log.error(startDate.toString());
                e.printStackTrace();
            }
        }
    }

    @Test
    public void UserStatisticSaveTest() {
        userStatisticService.save("2022-05-01");
        userStatisticService.save("2022-05-02");
        userStatisticService.save("2022-05-03");
        userStatisticService.save("2022-05-04");
    }

    @Test
    public void cardIssueStatisticsSaveTest() {
        cardIssueStatisticService.saveCardIssueStatistics("2022-05-01");
        cardIssueStatisticService.saveCardIssueStatistics("2022-05-02");
        cardIssueStatisticService.saveCardIssueStatistics("2022-05-03");
        cardIssueStatisticService.saveCardIssueStatistics("2022-05-04");
    }

    @Test
    public void terminalRevenueStatisticService() {
        terminalRevenueStatisticService.saveTerminalRevenueStatistic("2022-05-01");
        terminalRevenueStatisticService.saveTerminalRevenueStatistic("2022-05-02");
        terminalRevenueStatisticService.saveTerminalRevenueStatistic("2022-05-03");
        terminalRevenueStatisticService.saveTerminalRevenueStatistic("2022-05-04");
    }


    @Test
    public void totalRevenueStatisticService() {
        totalRevenueStatisticService.saveTotalRevenueStatistic("2022-05-01");
        totalRevenueStatisticService.saveTotalRevenueStatistic("2022-05-02");
        totalRevenueStatisticService.saveTotalRevenueStatistic("2022-05-03");
        totalRevenueStatisticService.saveTotalRevenueStatistic("2022-05-04");
    }


    @Test
    void userStatisticTest() {
        QueryWrapper<UserStatistic> wrapper = null;
            wrapper = new QueryWrapper<>();

            wrapper.ge( "operate_date", "2022-05-03");
            wrapper.le("operate_date", "2022-05-10");
        List<UserStatistic> list = userStatisticService.list(wrapper);
        for (UserStatistic userStatistic : list) {
            System.out.println(userStatistic);
        }

    }
}
