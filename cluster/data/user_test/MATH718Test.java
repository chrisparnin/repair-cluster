import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.distribution.*;

public class MATH718Test {

    @Test
    public void userDescTest() {
        assertEquals(500000, new BinomialDistribution(1000000, 0.5).inverseCumulativeProbability(0.5));
    }
}
