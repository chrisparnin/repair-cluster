import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.lang.text.StrBuilder;

/**
 * Extracted, user-submitted triggering test for Lang-61 (jira issue LANG-294)
 */
public class UserTest {
    @Test
    public void triggeringTest() {
        StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n");
        sb.deleteAll("\n%BLAH%");
        assertEquals("\nDo more stuff\neven more stuff\n", sb.toString());
    }
}
