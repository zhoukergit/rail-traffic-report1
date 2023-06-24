import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.statistic.StatisticApplication;
import com.example.statistic.entity.bo.TerminalRevenueBo;
import com.example.statistic.mapper.TerminalRevenueStatisticMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/10
 * 19:59
 */
@SpringBootTest(classes = StatisticApplication.class)
public class MapperTest {
    @Autowired
    TerminalRevenueStatisticMapper mapper;
//    @Test
//    public void test(){
//        List<TerminalRevenueBo> terminalRevenueBos = mapper.selectTerminalRevenueStatistic(1,1, "2022-05-01", "2022-05-04");
//        for (TerminalRevenueBo record : terminalRevenueBos) {
//            System.out.println("record = " + record);
//        }
//    }
//        @Test
//    public void test2(){
//        List<TerminalRevenueBo> terminalRevenueBos = mapper.selectTerminalRevenueStatistic(2,1, "2022-05-01", "2022-05-04");
//        for (TerminalRevenueBo record : terminalRevenueBos) {
//            System.out.println("record = " + record);
//        }
//    }
}
