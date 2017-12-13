import static org.junit.Assert.*;

import java.text.*;
import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME122Test {
    // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

  @Test
	public void testCanGetLocalizedTimeZoneForBerlin()
	{
    TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
    DateTimeZone.setDefault( DateTimeZone.forID("Europe/Berlin") );

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"), Locale.GERMAN);
		calendar.set(2000, Calendar.JANUARY, 1);
		assertEquals(new SimpleDateFormat("zzzz", Locale.GERMAN).format(calendar.getTime()),
		             DateTimeZone.forID("Europe/Berlin").getName(calendar.getTime().getTime(), Locale.GERMAN));
	}

	public static void main(String[] args)
	{
    TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
    DateTimeZone.setDefault( DateTimeZone.forID("Europe/Berlin") );

		String[][] zones = new DateFormatSymbols(Locale.ENGLISH).getZoneStrings();
		printBerlinToConsole(zones);
		zones = new DateFormatSymbols(Locale.GERMAN).getZoneStrings();
		printBerlinToConsole(zones);
		new TIME122Test().testCanGetLocalizedTimeZoneForBerlin();
	}

	private static void printBerlinToConsole(String[][] zones)
	{
		for (int i = 0; i < zones.length; ++i) {
			String[] set = zones[i];
			if (set[0].equals("Europe/Berlin")) {
				System.out.println(Arrays.asList(set));
			}
		}
	}
}
