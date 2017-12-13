import static org.junit.Assert.*;
import static org.joda.time.DateTimeFieldType.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME93bTest {
  // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
  public void userDescTest() {
    new Partial(weekyear(), 1).with(yearOfCentury(), 1);
    new Partial(year(), 1).with(yearOfCentury(), 1);
    new Partial(year(), 1).with(yearOfEra(), 1);
    new Partial(year(), 1).with(weekyearOfCentury(), 1);
  }

}



