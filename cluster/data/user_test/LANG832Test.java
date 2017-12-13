/**
 * Created by waddl on 2/7/2017.
 */
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.*;
import static org.junit.Assert.*;

// User comment: FDP does not handled unterminated quotes the same way as SimpleDateFormat
public class LANG832Test {
    @Test
    public void userDescTest() {
        String format = "'d'd'";
        String date = "d3";
        int fail = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
            sdf.parse(date);
        } catch (Exception e) {
            fail++;
        }
        try {
            // https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/time/FastDateParser.html
            FastDateFormat fdp = FastDateFormat.getInstance(format, TimeZone.getTimeZone("America/New_York"), Locale.US);
            fdp.parse(date);
            //should fail
        } catch (Exception e) {
            fail++;
        }
        assertTrue(fail == 0 || fail == 2);
    }
    // patch http://svn.apache.org/viewvc/commons/proper/lang/trunk/src/test/java/org/apache/commons/lang3/time/FastDateParserTest.java?view=markup&pathrev=1390795
}
