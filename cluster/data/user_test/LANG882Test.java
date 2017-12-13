/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.text.translate.*;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.CharBuffer;

import static org.junit.Assert.assertEquals;
public class LANG882Test {
    @Test
    public void userDescTest() {
        CharSequence cs1 = "1 < 2";
        CharSequence cs2 = CharBuffer.wrap("1 < 2".toCharArray());

        System.out.println(StringEscapeUtils.ESCAPE_HTML4.translate(cs1));
        System.out.println(StringEscapeUtils.ESCAPE_HTML4.translate(cs2));
        assertEquals(StringEscapeUtils.ESCAPE_HTML4.translate(cs1), StringEscapeUtils.ESCAPE_HTML4.translate(cs2));
    }
    // @Test
    // // testing user submitted (patch from dev)
    // public void patchTest1() throws IOException {
    //     final LookupTranslator lt = new LookupTranslator(new CharSequence[][]{{new StringBuffer("one"), new StringBuffer("two")}});
    //     final StringWriter out = new StringWriter();
    //     final int result = lt.translate(new StringBuffer("one"), 0, out);
    //     assertEquals("Incorrect codepoint consumption", 3, result);
    //     assertEquals("Incorrect value", "two", out.toString());
    // }
}
