/**
 * Created by waddl on 2/7/2017.
 */
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.lang3.time.*;
import static org.junit.Assert.*;

// TODO: Note- This always fails (even patch) on my machine, testing on vagrant instead...
public class LANG818Test {
    @Test
    public void userDescTest() {
        String f = "h:mma z";
        SimpleDateFormat sdf = new SimpleDateFormat(f);
        TimeZone t = TimeZone.getTimeZone("Asia/Shanghai");
        sdf.setTimeZone(t);
        final Calendar myCal = Calendar.getInstance(t);
        System.out.println(t.getID());
        String av = FastDateFormat.getInstance(f).format(myCal);
        System.out.println(myCal.getTime());
        System.out.println("ACTUAL: " + av);
        String ev = sdf.format(myCal.getTime());
        System.out.println("EXPECTED: " + ev);
        System.out.println(myCal.getTime());
        assertEquals(ev, av);

//           String[] availableZones = TimeZone.getAvailableIDs();
//           TimeZone currentZone = TimeZone.getDefault();
//           TimeZone anotherZone = null;
//            for (String zone : availableZones) {
//                if (!zone.equals(currentZone.getID())) {
//                    anotherZone = TimeZone.getTimeZone(zone);
//                    }
//                }
//                assertNotNull("Cannot find another timezone", anotherZone);
//                final String pattern = "h:mma z";
//                final Calendar cal = Calendar.getInstance(anotherZone);
//                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//                sdf.setTimeZone(anotherZone);
//                String expectedValue = sdf.format(cal.getTime());
//                String actualValue = FastDateFormat.getInstance(pattern).format(cal);
//                assertEquals(expectedValue, actualValue);
    }
    // patch https://issues.apache.org/jira/secure/attachment/12545424/commons-lang3-LANG-818.patch
}
/*
266	    public void testCalendarTimezoneRespected() {
 	267	        String[] availableZones = TimeZone.getAvailableIDs();
 	268	        TimeZone currentZone = TimeZone.getDefault();
 	269
 	270	        TimeZone anotherZone = null;
 	271	        for (String zone : availableZones) {
 	272	            if (!zone.equals(currentZone.getID())) {
 	273	                anotherZone = TimeZone.getTimeZone(zone);
263	274	            }
 	275	        }
 	276
 	277	        assertNotNull("Cannot find another timezone", anotherZone);
 	278
 	279	        final String pattern = "h:mma z";
 	280	        final Calendar cal = Calendar.getInstance(anotherZone);
 	281
 	282	        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
 	283	        sdf.setTimeZone(anotherZone);
 	284	        String expectedValue = sdf.format(cal.getTime());
 	285	        String actualValue = FastDateFormat.getInstance(pattern).format(cal);
 	286	        assertEquals(expectedValue, actualValue);
 */
