import org.apache.commons.math.distribution.*;
import org.apache.commons.math.MathException;

import org.junit.Test;
import static org.junit.Assert.*;

public class MATH227Test {
    @Test
    public void userDescTest() {
        FDistributionImpl dist = new FDistributionImpl(1,2);
        try {
            dist.inverseCumulativeProbability(0.05);
        } catch (MathException e) {
            fail(e.getMessage());
        }
    }
}
