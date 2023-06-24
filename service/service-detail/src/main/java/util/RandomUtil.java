package util;

import java.text.SimpleDateFormat;

/**
 * PACKAGE_NAME
 *
 * @author zhouke
 * 2022/5/6
 * 16:17
 */
public class RandomUtil {
    /**
     * 指定位数的纯数字编号
     */
    public static String randomSerialNumber(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <length ; i++) {
            sb.append((int) (Math.random()*10));
        }
        return sb.toString();
    }

    /**
     * 生成18位日期开头的交易流水号
     * @param StartDate
     * @param endDate
     * @return
     */
    public static String randomTransSn(String StartDate,String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //生成纯数字日期,8位
        String date = format.format(DateUtil.randomDate(StartDate, endDate)).replace("-", "");

        return date+"00000"+randomSerialNumber(5);
    }

        /**
     * 生成20位
     * @return
     */
    public static String randomOutTradeNo(){

        return "2096"+randomSerialNumber(16);
    }

    public static String randomVoucherNo(String StartDate,String endDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //生成纯数字日期,8位
        String date = format.format(DateUtil.randomDate(StartDate, endDate)).replace("-", "");

        return date+randomSerialNumber(8);
    }



    public static String randomTransSn(String date){
        return randomTransSn(date,date);
    }

    /**
     * 说明:指定是为了集中
     * @return
     */
    public static String randomCardNo(String[] cardNos){
        return null;
    }

    public static String randomCardNo(){
        return "03104980926000"+randomSerialNumber(6);
    }

    public static int  randomIntNumber(int start,int end){
        if (start>end){
            throw new IllegalArgumentException("start is larger than end");
        }
        int interval = end - start;
        return start+(int)(Math.random()*interval);
    }

    public static <T> T randomArrayItem(T[] array){
        return array[randomIntNumber(0,array.length)];
    }

    public static String randomTAC(){
        return cn.hutool.core.util.RandomUtil.randomString(8);
    }
}
