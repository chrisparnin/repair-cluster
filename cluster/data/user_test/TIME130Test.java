import static org.junit.Assert.*;

import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME130Test {
    // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    @Test
    public void userDescTest() {
        DateTime jdt = new DateTime(1500, 2, 29, 0, 0, 0, 0, JulianChronology.getInstanceUTC()); // Valid.
        DateTime gjdt = new DateTime(1500, 2, 29, 0, 0, 0, 0, GJChronology.getInstanceUTC()); // Invalid.
    }

}
