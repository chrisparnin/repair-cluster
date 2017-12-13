import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME90Test {
  // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
  public void userDescTest() {
    DateTimeZone zone = DateTimeZone.forID("America/Los_Angeles");
    DateTime when1 = new DateTime(2009, 11, 1, 0, 30, 0, 0, zone);
    DateTime when2 = new DateTime(2009, 11, 1, 1, 30, 0, 0, zone);
    DateTime when3 = new DateTime(2009, 11, 1, 2, 30, 0, 0, zone);
    System.out.println(when1);
    System.out.println(when2);
    System.out.println(when3);
    assertEquals(when1.toString(), "2009-11-01T00:30:00.000-07:00");
    assertEquals(when2.toString(), "2009-11-01T01:30:00.000-07:00");
    assertEquals(when3.toString(), "2009-11-01T02:30:00.000-08:00");
  }

  public static void main(String[] args) {
    new TIME90Test().userDescTest();
  }

}
