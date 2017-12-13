import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME160Test {
    @Test
    public void userDescTest() {
        assertEquals(new Period(-100).toString(), "PT-0.100S");
    }
}
