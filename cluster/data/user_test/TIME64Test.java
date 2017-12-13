import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME64Test {
  // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
	public void testPeriod() {
		PeriodFormatterBuilder pfmtbuilder1 = new PeriodFormatterBuilder().rejectSignedValues(true)
		.appendLiteral("P")
		.appendYears()
		.appendSuffix("Y")
		.appendMonths()
		.appendSuffix("M")
		.appendWeeks()
		.appendSuffix("W")
		.appendDays()
		.appendSuffix("D")
		.appendSeparatorIfFieldsAfter("T")
		.appendHours()
		.appendSuffix("H")
		.appendMinutes()
		.appendSuffix("M")
		.appendSecondsWithOptionalMillis()
		.appendSuffix("S");
		PeriodFormatterBuilder pfmtbuilder2 = new PeriodFormatterBuilder().rejectSignedValues(true);
		
		PeriodFormatter pfmt1 = pfmtbuilder1.toFormatter();
		PeriodFormatter pfmt2 = pfmtbuilder2.append(ISOPeriodFormat.standard() ).toFormatter();
		try {
			pfmt1.parsePeriod("PT1003199059S");
		}
		catch(IllegalArgumentException e) {
			fail("PT1003199059S should be parsable by pfmt1.");
		}
		try {
			pfmt2.parsePeriod("PT1003199059S");
		}
		catch(IllegalArgumentException e) {
			fail("PT1003199059S should be parsable by pfmt2.");
		}
	}

}



