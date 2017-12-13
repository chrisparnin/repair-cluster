import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.linear.OpenMapRealMatrix;

public class MATH679Test {

    @Test
    public void userDescTest() {
        // Either return the correct result (2) or throw and exception.
        try {
            OpenMapRealMatrix m = new OpenMapRealMatrix(3, Integer.MAX_VALUE);
            m.setEntry(0, 0, 2);
            m.setEntry(2, 2, 3);

            double result = m.getEntry(0, 0);
            assertEquals(2, result, 1e-10);
        } catch (Exception e) { }
    }
}
