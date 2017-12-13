/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
public class LANG807Test {
    @Test
    public void userDescTest() {
        try {
            RandomStringUtils.random(3,5,5,false,false);
            fail("No Exception");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Parameter end")
                    && e.getMessage().contains("must be greater than start"));
        }
    }
}
