package mappertest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.detail.DetailApplication;
import com.example.detail.entity.bo.AccountAnomalyBo;
import com.example.detail.entity.bo.AccountStatisticBo;
import com.example.detail.mapper.AccountCheckingMapper;
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
public class AccountCheckingMapperTest {
    @Autowired
    AccountCheckingMapper accountCheckingMapper;


    @Test
    public void selectAll(){
        IPage<AccountAnomalyBo> page = new Page<>(1,2);
        accountCheckingMapper.checkAccountAnomaly("2022-05-10","2022-05-13",page);
        System.out.println(page.getRecords());
    }



}
