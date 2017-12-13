import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by waddl on 2/7/2017.
 */
public class LANG805Test {
    @Test
    public void userDescTest() {
        try {
            // this code doesn't work for lang2 even though patch is the same?
            long seed = System.currentTimeMillis();
            assertEquals("aaa", RandomStringUtils.random(3,0,0,false,false,new char[]{'a'},new Random(seed)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(e.getMessage(), false);
        }
    }
}
