import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.complex.Complex;

public class MATH934Test {
    @Test
    public void userDescTest() {
        assertEquals(Complex.INF, Complex.ZERO.reciprocal());
    }
}
