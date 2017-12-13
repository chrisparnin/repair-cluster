import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.util.MathArrays;

public class MATH1005Test {
    private static final double EPS = 1e-10;

    @Test
    public void userDescTest() {
        double[] a = new double[]{1};
        double[] b = new double[]{1};
        assertEquals(1, MathArrays.linearCombination(a, b), EPS);
    }
}
