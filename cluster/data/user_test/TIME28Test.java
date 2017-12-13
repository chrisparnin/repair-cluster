import static org.junit.Assert.*;

import org.joda.time.*;
import org.joda.time.chrono.*;
import org.junit.Test;

public class TIME28Test {
    @Test
    public void userDescTest() {
        Chronology chronology = GJChronology.getInstance();

        LocalDate start = new LocalDate(2013, 5, 31, chronology);
        LocalDate expectedEnd = new LocalDate(-1, 5, 31, chronology); // 1 BC
        assertEquals(start.minusYears(2013), expectedEnd);
        assertEquals(start.plus(Period.years(-2013)), expectedEnd);
    }
}
