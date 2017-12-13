import static org.junit.Assert.*;
import static org.joda.time.DateTimeFieldType.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME93aTest {
  // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
  public void userDescTest() {
    new Partial(yearOfCentury(), 1).with(weekyear(), 1);
  }

}



