import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.distribution.HypergeometricDistribution;

public class MATH1021Test {
    @Test
    public void userDescTest() {
        HypergeometricDistribution a = new HypergeometricDistribution(43130568, 42976365, 50);
        assertEquals(0, a.getSupportLowerBound());
        assertEquals(50, a.getSupportUpperBound());
        int sample = a.sample();
        assertTrue("Sample value should be >=0, but was: " + sample, sample >= 0);
    }
}
