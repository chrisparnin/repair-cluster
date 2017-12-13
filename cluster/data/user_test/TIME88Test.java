import org.junit.Test;
import static org.junit.Assert.*;
import org.joda.time.*;
import org.joda.time.chrono.*;

public class TIME88Test {
    @Test
    public void userDescTest() {
        Partial a = new Partial(new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.hourOfDay() }, new int[] { 1, 1});
        Partial b = new Partial(DateTimeFieldType.year(), 1).with(DateTimeFieldType.hourOfDay(), 1);
        assert(a == b);

        try {
            new Partial(new DateTimeFieldType[] { DateTimeFieldType.clockhourOfDay(), DateTimeFieldType.hourOfDay() }, new int[] { 1, 1}); // throws 
            assertTrue("Should have thrown exception", false);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Types array must not contain duplicate"));
        }
        try {
            new Partial(DateTimeFieldType.clockhourOfDay(), 1).with(DateTimeFieldType.hourOfDay(), 1);
            assertTrue("Should have thrown exception", false);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Types array must not contain duplicate"));
        }
    }
}



