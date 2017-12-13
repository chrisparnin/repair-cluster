/**
 * Created by waddl on 2/7/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.math.NumberUtils;
public class LANG746Test {
    // NumberUtils.createNumber() should work equally for 0x1234 and 0X1234;
    // currently 0X1234 generates a NumberFormatException
    @Test
    public void userDescTest() {
        try {
            // NumberUtils.createNumber("0X1234");
            // assertTrue("int is equal to created num", 0x1234 == NumberUtils.createNumber("0X1234").intValue());
            // Testing patch
            assertTrue("createNumber(String) 9a failed", 0xFADE == NumberUtils.createNumber("0xFADE").intValue());
            assertTrue("createNumber(String) 9b failed", 0xFADE == NumberUtils.createNumber("0Xfade").intValue());
            assertTrue("createNumber(String) 10a failed", -0xFADE == NumberUtils.createNumber("-0xFADE").intValue());
            assertTrue("createNumber(String) 10b failed", -0xFADE == NumberUtils.createNumber("-0Xfade").intValue());

        } catch (NumberFormatException nfe) {
            System.out.println("caused NFE");
            assertTrue(false);
        }
        /* assertTrue("createNumber(String) 9a failed", 0xFADE == NumberUtils.createNumber("0xFADE").intValue());
 		   assertTrue("createNumber(String) 9b failed", 0xFADE == NumberUtils.createNumber("0Xfade").intValue());
 		   assertTrue("createNumber(String) 10a failed", -0xFADE == NumberUtils.createNumber("-0xFADE").intValue());
 		   assertTrue("createNumber(String) 10b failed", -0xFADE == NumberUtils.createNumber("-0Xfade").intValue());
 	    */
    }
}
