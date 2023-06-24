package mappertest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.entity.dto.TerminalRevenueDto;
import com.example.detail.DetailApplication;
import com.example.detail.entity.bo.CardDetailsBo;
import com.example.detail.mapper.TransRecordMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * mappertest
 *
 * @author zhouke
 * 2022/4/27
 * 15:23
 */
//引入主启动类的配置项(mapperScan)
@SpringBootTest(classes = DetailApplication.class)
public class TransMapperTest {
    @Autowired
    TransRecordMapper transRecordMapper;


    @Test
    public void test() {
        List<TerminalRevenueDto> dtos = transRecordMapper.selectTerminalRevenueDto("2022-05-01");
        for (TerminalRevenueDto dto : dtos) {
            System.out.println(dto);
        }
    }

    /**
     * 测试dao层接口
     */
    @Test
    public void testSelect() {
        transRecordMapper.selectList(null).forEach(
                System.out::println
        );
    }
}
