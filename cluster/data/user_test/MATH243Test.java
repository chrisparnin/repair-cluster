import org.apache.commons.math.util.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MATH243Test {
    @Test
    public void userDescTest() {
        try {
            MathUtils.gcd(Integer.MIN_VALUE, Integer.MIN_VALUE);
            fail("Exception expected");
        } catch (Exception e) {}
        try {
            MathUtils.gcd(Integer.MIN_VALUE, 0);
            fail("Exception expected");
        } catch (Exception e) {}
    }
}
