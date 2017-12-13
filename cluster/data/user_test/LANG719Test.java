/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.time.FastDateFormat;
import static org.junit.Assert.assertTrue;

// "FastDateFormat formats year differently than SimpleDateFormat in Java 7"
//
public class LANG719Test {
    @Test
    public void userDescTest() {
        String format = "Y";
        GregorianCalendar cal1 = new GregorianCalendar(2003, 0, 10, 15, 33, 20);
        GregorianCalendar cal2 = new GregorianCalendar(2003, 6, 10, 9, 00, 00);
        Date date1 = cal1.getTime();
        Date date2 = cal2.getTime();
        String s = "";
        String f = "";
        int fail = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
            s = sdf.format(date1);
            System.out.println(s);
            // https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/time/FastDateParser.html
            FastDateFormat fdf = FastDateFormat.getInstance(format, TimeZone.getTimeZone("America/New_York"), Locale.US);
            f = fdf.format(date1);
            System.out.println(f);
            // testing patch
            assertEquals(sdf.format(date1).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date1));
            assertEquals(sdf.format(date2).replaceAll("2003 03 03 03", "2003 2003 03 2003"), fdf.format(date2));
            // assertTrue(StringUtils.equals(s, f));
        } catch (Exception e) {
            fail++;
        }
    }
}
// patch http://svn.apache.org/viewvc/commons/proper/lang/trunk/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java?view=markup&pathrev=1390779
