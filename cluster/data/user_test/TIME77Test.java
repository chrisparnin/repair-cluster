import org.junit.Test;
import static org.junit.Assert.*;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;

public class TIME77Test {
    @Test
    public void userDescTest() {
        final MutableDateTime mdt = new MutableDateTime(2011, 10, 30, 3, 0, 0, 0, DateTimeZone.forID("Europe/Berlin"));
        String out1 = "Start date:   " + mdt + " (" + mdt.toInstant().getMillis() + ")";
        mdt.addHours(-1);
        String out2 = "addHours(-1): " + mdt + " (" + mdt.toInstant().getMillis() + ")";
        mdt.addHours(0);
        String out3 = "addHours(0):  " + mdt + " (" + mdt.toInstant().getMillis() + ")";
        mdt.addDays(0);
        String out4 = "addDays(0):   " + mdt + " (" + mdt.toInstant().getMillis() + ")";

        assertEquals(out1, "Start date:   2011-10-30T03:00:00.000+01:00 (1319940000000)");
        assertEquals(out2, "addHours(-1): 2011-10-30T02:00:00.000+01:00 (1319936400000)");
        assertEquals(out3, "addHours(0):  2011-10-30T02:00:00.000+01:00 (1319936400000)");
        assertEquals(out4, "addDays(0):   2011-10-30T02:00:00.000+01:00 (1319936400000)");
    }
}



