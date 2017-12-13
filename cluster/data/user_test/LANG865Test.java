/**
 * Created by waddl on 2/7/2017.
 */

import org.apache.commons.lang3.LocaleUtils;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class LANG865Test {
    private static void assertValidToLocale(
            final String localeString, final String language,
            final String country, final String variant) {
        final Locale locale = LocaleUtils.toLocale(localeString);
        assertNotNull("valid locale", locale);
        assertEquals(language, locale.getLanguage());
        assertEquals(country, locale.getCountry());
        assertEquals(variant, locale.getVariant());
    }
    // user provided patch w/ detailed tests
    @Test
    public void userDescTest() {
             assertValidToLocale("_GB", "", "GB", "");
             assertValidToLocale("_GB_P", "", "GB", "P");
             assertValidToLocale("_GB_POSIX", "", "GB", "POSIX");

//             try {
//                 LocaleUtils.toLocale("_G");
//                 fail("Must be at least 3 chars if starts with underscore");
//             } catch (final IllegalArgumentException iae) {
//             }
    }
}
