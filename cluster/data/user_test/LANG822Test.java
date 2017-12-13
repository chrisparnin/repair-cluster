/**
 * Created by waddl on 2/7/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang3.math.NumberUtils;
public class LANG822Test {
    @Test
    // User comment: "Returning nulll is contrary to the Javadoc and the behaviour for other methods
    // which would throw NumberFormatException."
    public void userDescTest() {
        try {
            NumberUtils.createNumber("--1.1E-700F");
            System.out.println("Failed");
            assertNotEquals(null, NumberUtils.createNumber("--1.1E-700F"));
        } catch (NumberFormatException nfe) {
            System.out.println("Passed");
            assertEquals(true, true);
        }
    }
}
