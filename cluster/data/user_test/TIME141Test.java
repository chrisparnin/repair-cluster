import static org.junit.Assert.*;

import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME141Test {
    @Test
    public void userDescTest() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        DateTimeZone.setDefault( DateTimeZone.forID("America/Sao_Paulo") );

        DateTime dtch;
        {
            dtch = new DateTime(2012,2,25,5,5,5,5).millisOfDay().withMaximumValue();
            System.out.println( dtch ); // prints: 2012-02-25T23:59:59.999-02:00 //Were are at the first 23:** of the day.
            //At this point dtch have the -02:00 offset
        }
        {
            dtch = dtch.plus(60001);
            System.out.println( dtch ); // prints: 2012-02-25T23:01:00.000-03:00 //Were are at the first minute of the second 23:** of the day. Ok its correct
            //At this point dtch have the -03:00 offset
        }
        {
            dtch = dtch.withEarlierOffsetAtOverlap();
            System.out.println( dtch ); // prints: 2012-02-25T23:01:00.000-02:00 //Were are at the first minute of the first 23:** of the day. Ok its correct
            //At this point dtch have the -02:00 offset ( because we called withEarlierOffsetAtOverlap() ) // This method is working perfectly
        }       
        {
            dtch = dtch.withLaterOffsetAtOverlap();
            System.out.println( dtch ); // prints: 2012-02-25T23:01:00.000-02:00 //Were are at the first minute of the first 23:** of the day. 
            // Here is the problem we should have a -03:00 offset here since we called withLaterOffsetAtOverlap() expecting to change to the second 23:** of the day
            assertEquals(dtch.toString(), "2012-02-25T23:01:00.000-03:00");
        }
    }

}
