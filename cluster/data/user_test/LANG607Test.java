import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.Assert;

public class LANG607Test {
    private static final String CharU20000 = "\uD840\uDC00";
    private static final String CharU20001 = "\uD840\uDC01";
    @Test  
    public void StringUtilsUnicode2()
    {
        //StringUtils.containsAny methods incorrectly matches Unicode 2.0+ supplementary characters.
        //For example, define a test fixture to be the Unicode character U+20000 where U+20000 is written in Java source as "\uD840\uDC00"
        //You can see Unicode supplementary characters correctly implemented in the JRE call:
        assertEquals(-1, CharU20000.indexOf(CharU20001));

        // But this is broken:
        assertEquals(false, StringUtils.containsAny(CharU20000, CharU20001));
        assertEquals(false, StringUtils.containsAny(CharU20001, CharU20000));
        // This is fine:
        assertEquals(true, StringUtils.contains(CharU20000 + CharU20001, CharU20000));
        assertEquals(true, StringUtils.contains(CharU20000 + CharU20001, CharU20001));
        assertEquals(true, StringUtils.contains(CharU20000, CharU20000));
        assertEquals(false, StringUtils.contains(CharU20000, CharU20001));
    }
}
 
