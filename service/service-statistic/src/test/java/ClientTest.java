import com.example.common.entity.R;
import com.example.common.entity.dto.UserStatisticDto;
import com.example.statistic.StatisticApplication;
import com.example.statistic.service.client.ServiceDetailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/5
 * 19:58
 */
@SpringBootTest(classes = StatisticApplication.class)
public class ClientTest {
    @Autowired
    ServiceDetailClient serviceDetailClient;

    @Test
    void test1() {
        R<List<UserStatisticDto>> result = serviceDetailClient.getUserStatisticDto("2021-06-25");
        List<UserStatisticDto> data = result.getData();
        System.out.println(data);
    }

}
