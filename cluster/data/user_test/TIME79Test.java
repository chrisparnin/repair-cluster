import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;

public class TIME79Test {
    @Test
    public void userDescTest() {
        
        Date startDate = new Date();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // nothing to do
        }
        Date endDate = new Date();

        Period p1 = new Period(new DateTime(startDate.getTime()), new DateTime(endDate.getTime()), PeriodType.forFields(new DurationFieldType[]{DurationFieldType.months(), DurationFieldType.weeks()})).normalizedStandard(PeriodType.forFields(new DurationFieldType[]{DurationFieldType.months(), DurationFieldType.weeks()}));
        p1.getMonths();

        Period p2 = new Period(new DateTime(startDate.getTime()), new DateTime(endDate.getTime()), PeriodType.standard()).normalizedStandard(PeriodType.standard());
        p2.getMonths();

        Period p3 = new Period(new DateTime(startDate.getTime()), new DateTime(endDate.getTime()), PeriodType.standard().withYearsRemoved()).normalizedStandard(PeriodType.standard().withYearsRemoved());
        p3.getMonths();
    }
}
