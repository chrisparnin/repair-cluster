import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.junit.Test;

public class TIME21Test {
    @Test
    public void userDescTest() {
        final DateTimeZone NEWYORK = DateTimeZone.forID("America/New_York");

        DateTimeFormatter f = DateTimeFormat.forPattern("M d").withLocale(Locale.UK);
        MutableDateTime result = new MutableDateTime(2000, 1, 1, 0, 0, 0, 0, NEWYORK);
        assertEquals(4, f.parseInto(result, "2 29", 0));
        assertEquals(new MutableDateTime(2000, 2, 29, 0, 0, 0, 0, NEWYORK), result);
    }
}
