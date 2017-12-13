import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math.stat.Frequency;

public class MATH259aTest {

    @Test
    public void userDescTest() {
        Frequency f = new Frequency();
        final Object OBJ = new Object();
        try {
            f.addValue(OBJ); // This ought to fail, but doesn't, causing the unexpected behaviour below
            System.out.println(f.getCount(OBJ)); // 0
            System.out.println(f.getPct(OBJ)); // 0.0
            fail();
        } catch(Exception e) {
        }
    }
}
