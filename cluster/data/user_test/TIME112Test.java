import static org.junit.Assert.*;

import org.joda.time.*;
import org.junit.Test;

import java.util.SimpleTimeZone;

public class TIME112Test {
    @Test
    public void userDescTest() {
        DateTimeZone z1 = DateTimeZone.forTimeZone(new SimpleTimeZone(1, "MET"));
        DateTimeZone z2 = DateTimeZone.forTimeZone(new SimpleTimeZone(1, "CET"));

        assertEquals(z1, z2);
    }
}
