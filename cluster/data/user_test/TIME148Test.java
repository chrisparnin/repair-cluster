import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME148Test {
    DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    @Test
    public void userDescTest() {
        DateTimeFormatter f = DateTimeFormat
                  .forPattern("M")
                  .withLocale(Locale.UK);

        MutableDateTime expect = new MutableDateTime(2004, 5, 9, 12, 20, 30, 0, LONDON);
        MutableDateTime result = new MutableDateTime(2004, 1, 9, 12, 20, 30, 0, LONDON);
        assertEquals(1, f.parseInto(result, "5", 0));
        assertEquals(expect, result);
    }

}
