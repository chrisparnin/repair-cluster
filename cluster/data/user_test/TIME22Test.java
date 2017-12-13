import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.junit.Test;

public class TIME22Test {
    @Test
    public void userDescTest() {
        final LocalDate january12012 = new LocalDate(2012, 1,1);
        final LocalDate february292012 = new LocalDate(2012, 2, 29);
        // OK
        assertEquals(59, Days.daysBetween(january12012, february292012).getDays());

        final MonthDay january1 = new MonthDay(1,1);
        final MonthDay february29 = new MonthDay(2, 29);
        // FAIL



        // Fails:
        new MonthDay(new LocalDateTime(2013, 03, 01, 15, 00)).minusDays(200);
        // Passes:
        new MonthDay(new LocalDateTime(2013, 03, 01, 15, 00)).minusDays(1);
    }
}
