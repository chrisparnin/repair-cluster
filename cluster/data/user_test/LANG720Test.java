import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.lang3.*;

import java.net.URLEncoder;

public class LANG720Test {
    @Test
    public void userDescTest() throws Exception {  // from user
        String str1 = "\uD842\uDFB7" + "A";
        String str2 = StringEscapeUtils.escapeXml(str1);
        // The value of str2 must be equal to the one of str1,
        // because str1 does not contain characters to be escaped.
        // However, str2 is diffrent from str1.
        assertEquals(URLEncoder.encode(str1, "UTF-16BE"), URLEncoder.encode(str2, "UTF-16BE"));
//        System.out.println(URLEncoder.encode(str1, "UTF-16BE")); //%D8%42%DF%B7A
//        System.out.println(URLEncoder.encode(str2, "UTF-16BE")); //%D8%42%DF%B7%FF%FD
    }
}
