/**
 * Created by waddl on 2/7/2017.
 */
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;
import java.util.Locale;
//import org.testng.annotations.Test;
//import com.scispike.foundation.i18n.StringToLocaleConverter;
import org.apache.commons.lang3.LocaleUtils;
//import org.springframework.core.convert.converter.Converter;
import org.junit.Test;
import static org.junit.Assert.*;

public class LANG879Test {
    // TODO: NOTE - User's code leaves in suffixes which the patch removes,
    // TODO: I believe this is because the code will always get an error without it (see 'should not parse' code)
        // LocaleUtils test fails with new Locale "ja_JP_JP_#u-ca-japanese" of JDK7
        //StringToLocaleConverter converter = new StringToLocaleConverter();
        public void testStringToLocale(Locale l) {
            Locale locale = new Locale(l.getLanguage(), l.getCountry(), l.getVariant());
            if (l.equals(locale)) {
                String s = l.toString();
                Locale loc;
                int suff = s.indexOf("_#");
                if (suff == -1) {
                    suff = s.indexOf("#");
                }
                if (suff >= 0) {
                    try {
                        loc = LocaleUtils.toLocale(s);
                        fail("should not parse");
                    } catch (IllegalArgumentException iae) {
                        s = s.substring(0, suff);
                    }
                }
                loc = LocaleUtils.toLocale(s);
                assertTrue(l.equals(loc));
            }
        }

        @Test
        public void testAllLocales() {
            Locale[] locales = Locale.getAvailableLocales();
            for (Locale l : locales) {
                testStringToLocale(l);
            }
        }

//    public class StringToLocaleConverter implements Converter<String, Locale> {
//        @Override
//        public Locale convert(String source) {
//            if (source == null)
//            { return LocaleToStringConverter.DEFAULT; }
//            return LocaleUtils.toLocale(source);
//        }
//    }
}
