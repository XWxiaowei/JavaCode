package com.flybob.util.moneyUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiang.wei
 * @Desc 金额转换类
 * @date 2017/5/31 16:09
 */

public class MoneyUtil {
    private static Logger logger = LoggerFactory.getLogger(MoneyUtil.class);
    private static final double CENT_RATE = 100.00; //整除比例
    private final static Map<String, ThreadLocal<DecimalFormat>> dfMap = new HashMap<>();

    private static DecimalFormat getdf(final String pattern) {
        ThreadLocal<DecimalFormat> dfThread = dfMap.get(pattern);
        if (dfThread == null) {
            synchronized (MoneyUtil.class) {
                dfThread = dfMap.get(pattern);
                if (dfThread == null) {
                    dfThread = new ThreadLocal<DecimalFormat>() {
                        protected DecimalFormat initialValue() {
                            return new DecimalFormat(pattern);
                        }
                    };
                    dfMap.put(pattern, dfThread);
                }
            }
        }
        return dfThread.get();
    }

    /**
     * @param cent 分
     * @return
     * @description 分转元
     * @date 2017/6/3 17:43
     * @author xiang.wei
     */
    public static String cent2Yuan(long cent) {
        return getdf("0.00").format(cent / CENT_RATE);
    }

    /**
     * @param yuan 元
     * @return
     * @description 元转分
     * @date 2017/6/3 17:53
     * @author xiang.wei
     * 备注：Java 代码中以四舍五入的方式保留2位小数，不应该使用MathContext，
     * 而应该使用BigDecimal.setScale！
     */
    public static long yuan2Cent(double yuan) {
        return Math.round(yuan * CENT_RATE);
    }

    /**
     * @param fen
     * @return java.math.BigDecimal
     * @description 分转元
     * @date 2017/6/3 17:57
     * @author xiang.wei
     */
    public static BigDecimal fenToYuan(String fen) {
        return new BigDecimal(Double.valueOf(fen)).divide(BigDecimal
                .valueOf(100),2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal yuanToFen(String yuan) {
        return new BigDecimal(Double.valueOf(yuan)).multiply(BigDecimal.valueOf(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
