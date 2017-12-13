import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME107Test {
  // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
  public void userDescTest() {
    DateTimeFormatter dtf = DateTimeFormat.forPattern("xxxxMM'w'ww");
    DateTime dt = dtf.parseDateTime("201101w01");       
    System.out.println(dt);
    assertEquals(dt.toString().substring(0,4), "2011");
  }
}
