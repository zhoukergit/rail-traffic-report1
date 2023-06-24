import org.junit.jupiter.api.Test;
import util.DateUtil;
import util.RandomUtil;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/6
 * 16:23
 */
public class UtilsTest {
    @Test
    public void dateUtilTest() {
        for (int i = 0; i < 10; i++) {

            System.out.println(DateUtil.randomDateTimeByHour("2021-06-26 12", "2021-06-26 22"));
        }
    }
    @Test
    public void transSnTest(){
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.randomTransSn("2021-06-25", "2021-06-30"));
        }
    }


}
