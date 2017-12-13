import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME151Test {
    @Test
    public void userDescTest() {
        // Fails
        final MonthDay isoLeap = new MonthDay(DateTimeConstants.FEBRUARY, 29, ISOChronology.getInstanceUTC());
        System.out.println(isoLeap);
        System.out.println(isoLeap.plusDays(2));

        // Fails
        isoLeap.plusMonths(1);
        isoLeap.plusMonths(-1);
        isoLeap.minusMonths(1);
        isoLeap.minusMonths(-1);
        isoLeap.minusDays(-1);

        // Succeeds
        isoLeap.minusDays(1);
        isoLeap.plusDays(-1);

        // Succeeds
        System.out.println(isoLeap.minusDays(1).plusDays(2));
    }
}
