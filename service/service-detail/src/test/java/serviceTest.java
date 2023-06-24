import com.example.detail.DetailApplication;
import com.example.detail.entity.dto.CodePaymentDetailsDto;
import com.example.detail.entity.query.CardPaymentDetailsQuery;
import com.example.detail.entity.query.CodePaymentDetailsQuery;
import com.example.detail.service.TransRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintWriter;
import java.util.List;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/6/12
 * 15:25
 */
@SpringBootTest(classes = DetailApplication.class)
public class serviceTest {

    @Autowired
    TransRecordService transRecordService;

    @Test
    void test1() {
        CodePaymentDetailsQuery codePaymentDetailsQuery = new CodePaymentDetailsQuery();
        try {
            List<CodePaymentDetailsDto> codePaymentDetails = transRecordService.getCodePaymentDetails(1, 10, codePaymentDetailsQuery);
            for (CodePaymentDetailsDto codePaymentDetail : codePaymentDetails) {
                System.out.println(codePaymentDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
