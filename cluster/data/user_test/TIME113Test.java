import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME113Test {
    // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
  public void userDescTest() {
    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    DateTimeZone.setDefault( DateTimeZone.forID("GMT") );
    testForJodaForum();

    TimeZone.setDefault(TimeZone.getTimeZone("America/Chicago"));
    DateTimeZone.setDefault( DateTimeZone.forID("America/Chicago") );
    testForJodaForum();
  }

  public static void testForJodaForum() {
    System.out.println("Timezone: " + DateTimeZone.getDefault());

    //Duration of more than 24 hours
    Duration aDuration = new Duration(DateTimeConstants.MILLIS_PER_HOUR * 30 + DateTimeConstants.MILLIS_PER_MINUTE * 50
        + DateTimeConstants.MILLIS_PER_SECOND * 14);

    System.out.println("Duration before: " + aDuration);
    Period period = aDuration.toPeriod();
    System.out.println("Period after: " + period);        
    assertEquals(period.toString(), "PT30H50M14S");
  }
}
