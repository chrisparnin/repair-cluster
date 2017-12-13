import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.lang3.*;

public class LANG710Test {
    @Test
    public void userDescTest() {  // testEscapeSurrogatePairs from user
        try {
            StringEscapeUtils.unescapeHtml4("&#03");
        } catch (StringIndexOutOfBoundsException e) {
            assertTrue("Throws out of bounds exception", false);
        }
    }

}
