import static org.junit.Assert.*;

import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME124Test {
    // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    @Test
    public void userDescTest() {
        DateTime britishDate = new DateTime(2011, 10, 30, 1, 59, 0, 0, DateTimeZone.forID("Europe/London"));
        DateTime norwDate = new DateTime(2011, 10, 30, 2, 59, 0, 0, DateTimeZone.forID("Europe/Oslo"));
        DateTime finnishDate = new DateTime(2011, 10, 30, 3, 59, 0, 0, DateTimeZone.forID("Europe/Helsinki"));

        assertEquals(britishDate.toString(), "2011-10-30T01:59:00.000+01:00");
        assertEquals(norwDate.toString(), "2011-10-30T02:59:00.000+02:00");
        assertEquals(finnishDate.toString(), "2011-10-30T03:59:00.000+03:00");

    }

}
