import static org.junit.Assert.*;

import java.util.*;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME126Test {
    // DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss.SSS ZZZ");
    private static int numTimeZonesTested = 0;
    private static int numTimeZonesPassed = 0;
    private static int numTimeZonesFailed = 0;
    private static int numTimeZonesException = 0;

    private static String convertDateTimeToFormattedString(DateTime dateTime) {
        return formatter.print(dateTime);
    }

    private static DateTime parseStringToDateTime(String formattedDateTime) {
        return formatter.parseDateTime(formattedDateTime);
    }

    private static void testDateTimeFormatter(DateTime dateTime, String timeZone) {
        numTimeZonesTested++;

        final String dateTimeZoneId = dateTime.getZone().getID();

        if (!timeZone.equals(dateTimeZoneId)) {
            numTimeZonesFailed++;
            System.out.println(timeZone + " failed to construct into the proper date time zone - constructed time zone = " + dateTimeZoneId);
            return;
        }
        try {
            DateTime convertedDateTime = parseStringToDateTime(convertDateTimeToFormattedString(dateTime));

            if (dateTime.equals(convertedDateTime)) {
                numTimeZonesPassed++;
                //System.out.println(dateTime.getZone().getID() + " passed.");
            } else {
                numTimeZonesFailed++;
                System.out.println("Formatter failed for time zone ID: " + dateTimeZoneId + "    converted it to: " + convertedDateTime.getZone().getID());
            }
        } catch (IllegalArgumentException iae) {
            assertEquals("IllegalArgumentException", true, false);
            numTimeZonesException++;
            System.out.println("Formatter threw exception for time zone id: " + dateTimeZoneId);
        }
    }

    @Test
    public void userDescTest() {
        Set<String> timeZones = DateTimeZone.getAvailableIDs();

        for (String timeZone : timeZones) {
            testDateTimeFormatter(DateTime.now().withZone(DateTimeZone.forID(timeZone)), timeZone);
        }

        System.out.println();
        System.out.println("Number of Time Zones tested: " + numTimeZonesTested);
        System.out.println("Number passed:     " + numTimeZonesPassed);
        System.out.println("Number failed:     " + numTimeZonesFailed);
        System.out.println("Number exceptions: " + numTimeZonesException);
        System.out.println();
    }
}
