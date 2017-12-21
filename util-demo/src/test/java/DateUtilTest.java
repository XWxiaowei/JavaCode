import com.flybob.util.dateUtil.DateUtil;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;


/**
 * 测试
 */
public class DateUtilTest {
    @Ignore
    @Test
    public void testParse() {
        String str = "2016-12-11 09:38:19";
        System.out.println(DateUtil.parseDate(str, DateUtil.YMDHMS_));
    }

    @Ignore
    @Test
    public void testFormat() {
        String str = DateUtil.formatDate(new Date(), DateUtil.YMDHMS_);
        System.out.println(str);
    }

    @Test
    public void testGetsdf() {
        DateUtil.formatDate(new Date(),DateUtil.YMD_);
        new Thread(()->{
            DateUtil.formatDate(new Date(),DateUtil.YMD_);
        }).start();
        new Thread(()->{
            DateUtil.formatDate(new Date(),DateUtil.YMD_);
        }).start();

    }


}
