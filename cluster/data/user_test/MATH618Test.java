import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.complex.Complex;

public class MATH618Test {
    @Test
    public void userDescTest() {
        Complex c1 = new Complex(2.,3.);
        Complex c2 = new Complex(4., Double.NaN);
        Complex c3 = c1.add(c2);
        assertTrue(c3.isNaN());
        
        Complex c4 = c1.add(Complex.NaN);
        assertTrue(c4.isNaN());
    }
}
