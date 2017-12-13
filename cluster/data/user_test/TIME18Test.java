import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME18Test {
    @Test
    public void testDateTimeZoneBuilder() throws Exception {
        getTestDataTimeZoneBuilder().toDateTimeZone("TestDTZ1", true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getTestDataTimeZoneBuilder().toDateTimeZone("TestDTZ2", true);
            }
        });
        t.start();
        t.join();
    }

    private DateTimeZoneBuilder getTestDataTimeZoneBuilder() {
         return new DateTimeZoneBuilder()
         .addCutover(1601, 'w', 1, 1, 1, false, 7200000)
         .setStandardOffset(3600000)
         .addRecurringSavings("", 3600000, 1601, Integer.MAX_VALUE, 'w', 3, -1, 1, false, 7200000)
         .addRecurringSavings("", 0, 1601, Integer.MAX_VALUE, 'w', 10, -1, 1, false, 10800000);
    }
}
