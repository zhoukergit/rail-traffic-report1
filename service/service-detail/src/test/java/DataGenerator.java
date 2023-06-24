import com.example.detail.DetailApplication;
import com.example.detail.entity.DownloadedBill;
import com.example.detail.entity.PayUnion;
import com.example.detail.entity.TransRecord;
import com.example.detail.mapper.DownloadedBillMapper;
import com.example.detail.mapper.PayUnionMapper;
import com.example.detail.mapper.TransRecordMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.DateUtil;
import util.RandomUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/6
 * 16:11
 */
@SpringBootTest(classes = DetailApplication.class)
public class DataGenerator {
    @Autowired
    TransRecordMapper transRecordMapper;

    @Autowired
    PayUnionMapper payUnionMapper;

    @Autowired
    DownloadedBillMapper downloadedBillMapper;
    
    String startDate="2022-05-01";
    String endDate="2022-05-30";
    int times = 1000;
    int halfTimes = 500;
    /**
     * 生成售卡数据
     */
    @Test
    public void sellCardGenerator() {
        Integer dataType = 1;
        int transType ;
        String cardNo;
        String cardSn;
        LocalDateTime transTime;
        String transSn;
        TransRecord transRecord;
        String terminalNo;
        String ticketType;
        String userId;
        //若干条TVM售卡记录,售卡类型为储值卡
        for (int i = 0; i < halfTimes; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            terminalNo = RandomUtil.randomArrayItem(new String[]{"0401T191", "0401T192", "0401T193"});
            transRecord = new TransRecord(
                    transSn, dataType, transType, "TVM", cardNo, cardSn, transTime, 10, 0, 10, 0, null, terminalNo, "0187745OFFFFFFFF"
            );
            transRecordMapper.insert(transRecord);
        }
        //若干条BOM售卡记录,售卡类型为剩下全部
        for (int i = 0; i < times; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            ticketType = RandomUtil.randomArrayItem(new String[]{"普通卡", "储值票", "学生卡", "爱心卡"});
            terminalNo = RandomUtil.randomArrayItem(new String[]{"B001", "B002", "B004", "B005"});
            userId = "000" + terminalNo.substring(1);
            transRecord = new TransRecord(
                    transSn, dataType, transType, ticketType, cardNo, cardSn, transTime, 10, 0, 10, 0, userId, terminalNo, "0187745OFFFFFFFF"
            );
            transRecordMapper.insert(transRecord);
        }
    }

    /**
     * 生成退卡记录
     */
    @Test
    public void returnCardGenerator() {
        Integer dataType = 2;
        int transType = RandomUtil.randomIntNumber(1, 3);
        String cardNo = RandomUtil.randomCardNo();
        String cardSn = cardNo;
        LocalDateTime transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
        String transSn = RandomUtil.randomTransSn(startDate, endDate);
        TransRecord transRecord = null;
        String terminalNo = RandomUtil.randomArrayItem(new String[]{"0401T191", "0401T192", "0401T193"});
        String ticketType;
        String userId;
        int balance;
        //50条BOM退卡记录
        for (int i = 0; i < halfTimes; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            terminalNo = RandomUtil.randomArrayItem(new String[]{"B001", "B002", "B004", "B005"});
            ticketType = RandomUtil.randomArrayItem(new String[]{"普通卡", "储值票", "学生卡", "爱心卡"});
            userId = "000" + terminalNo.substring(1);
            balance = RandomUtil.randomIntNumber(0, 100);
            transRecord = new TransRecord(
                    transSn, dataType, transType, ticketType, cardNo, cardSn, transTime, balance + 10, balance, 10, 0, userId, terminalNo, "0187745OFFFFFFFF"
            );
            transRecordMapper.insert(transRecord);
        }
    }

    @Test
    public void TopUpGenerator() {
        Integer dataType = 3;
        int transType = RandomUtil.randomIntNumber(1, 3);
        String cardNo = RandomUtil.randomCardNo();
        String cardSn = cardNo;
        LocalDateTime transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
        String transSn = RandomUtil.randomTransSn(startDate, endDate);
        TransRecord transRecord = null;
        String terminalNo = RandomUtil.randomArrayItem(new String[]{"0401T191", "0401T192", "0401T193"});
        String ticketType;
        String userId;
        int transAmount;
        int balance;
        //50条TVM充值记录
        for (int i = 0; i < halfTimes; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            terminalNo = RandomUtil.randomArrayItem(new String[]{"0401T191", "0401T192", "0401T193"});
            ticketType = RandomUtil.randomArrayItem(new String[]{"TVM", "普通卡", "BOM", "学生卡", "爱心卡"});
            transAmount = RandomUtil.randomIntNumber(0, 10) * 10;
            balance = RandomUtil.randomIntNumber(0, 20);
            transRecord = new TransRecord(
                    transSn, dataType, transType, ticketType, cardNo, cardSn, transTime, transAmount, balance, null, 0, null, terminalNo, "0187745OFFFFFFFF"
            );
            transRecordMapper.insert(transRecord);
        }
        //50条BOM充值记录
        for (int i = 0; i < halfTimes; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            terminalNo = RandomUtil.randomArrayItem(new String[]{"B001", "B002", "B004", "B005"});
            ticketType = RandomUtil.randomArrayItem(new String[]{"普通卡", "储值票", "学生卡", "爱心卡"});
            userId = "000" + terminalNo.substring(1);
            transAmount = RandomUtil.randomIntNumber(0, 10) * 10;
            balance = RandomUtil.randomIntNumber(0, 20);
            transRecord = new TransRecord(
                    transSn, dataType, transType, ticketType, cardNo, cardSn, transTime, transAmount, balance, null, 0, userId, terminalNo, "0187745OFFFFFFFF"
            );
            transRecordMapper.insert(transRecord);
        }
    }

    /**
     * 生成刷卡交易明细
     * 卡号随机
     * 需要指定终端交易序号,终端编号(POE-040100),tac随机
     */
    @Test
    public void cardPaymentGenerator() {
        Integer dataType = 4;
        int transType = RandomUtil.randomIntNumber(1, 3);
        String cardNo = RandomUtil.randomCardNo();
        String cardSn = cardNo;
        LocalDateTime transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
        String transSn = RandomUtil.randomTransSn(startDate, endDate);
        TransRecord transRecord = null;
        String terminalNo = RandomUtil.randomArrayItem(new String[]{"0401T191", "0401T192", "0401T193"});
        String ticketType;
        String userId;
        String tac = RandomUtil.randomTAC();
        String terminalSn = "1000000000000281";
        int transAmount;
        int balance;
        long terminalTransIndex;
        //50条TVM充值记录
        for (int i = 0; i < halfTimes; i++) {
            transType = RandomUtil.randomIntNumber(1, 3);
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            terminalNo = RandomUtil.randomArrayItem(new String[]{"POE-0400", "POE-0401", "POE-0408", "POE-0412", "POE-0481"});
            ticketType = RandomUtil.randomArrayItem(new String[]{"普通卡", "储值票", "学生卡", "爱心卡"});
            transAmount = RandomUtil.randomIntNumber(0, 15);
            balance = RandomUtil.randomIntNumber(0, 50);
            terminalTransIndex = Long.parseLong("100000000000" + RandomUtil.randomSerialNumber(4));
            tac = RandomUtil.randomTAC();
            transRecord = new TransRecord(
                    transSn, dataType, 3, ticketType, cardNo, cardSn, transTime, transAmount, balance, null, 0, null, terminalNo, "0187745OFFFFFFFF"
            );
            transRecord.setTac(tac);
            transRecord.setTerminalTransIndex(terminalTransIndex);
            transRecordMapper.insert(transRecord);
        }
    }

    /**
     * 扫码交易生成
     * 同时生成银行/系统流水信息
     */
    @Test
    public void ScanCodeGenerator() {
        String transSn;
        String outTradeNo;
        String ticketType = "二维码";
        String cardNo = RandomUtil.randomCardNo();
        String cardSn = cardNo;
        int transType = 3;
        Integer downLoadedBillId = 10001;
        LocalDateTime transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
        int transAmount;
        String orderType;
        String voucherNo;
        for (int i = 0; i < times; i++) {
            cardNo = RandomUtil.randomCardNo();
            cardSn = cardNo;
            transSn = RandomUtil.randomTransSn(startDate, endDate);
            transAmount = RandomUtil.randomIntNumber(0, 25);
            outTradeNo = RandomUtil.randomOutTradeNo();
            voucherNo = RandomUtil.randomVoucherNo(startDate, endDate);
            downLoadedBillId++;
            orderType = "微信";
            TransRecord transRecord = new TransRecord(transSn,5,transType, ticketType,transTime, transAmount,outTradeNo,cardNo,cardSn);

            DownloadedBill downloadedBill = new DownloadedBill(downLoadedBillId, outTradeNo, transTime, orderType, transAmount);
            PayUnion payUnion = new PayUnion(outTradeNo, voucherNo, transAmount, "20", "1234567");
            transTime = LocalDateTime.ofInstant(DateUtil.randomDate(startDate, endDate).toInstant(), ZoneId.systemDefault());
            transRecordMapper.insert(transRecord);
            downloadedBillMapper.insert(downloadedBill);
            payUnionMapper.insert(payUnion);
        }
    }
}
