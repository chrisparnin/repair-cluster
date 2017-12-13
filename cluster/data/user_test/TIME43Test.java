import static org.junit.Assert.*;

import org.joda.time.*;
import org.junit.Test;

public class TIME43Test {
    @Test
    public void userDescTest() {
        try {
            DateTimeZone.forOffsetHoursMinutes(24,0);
            fail();
        } catch (Exception e) {
        }
    }
}
