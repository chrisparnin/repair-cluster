import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math3.distribution.MultivariateNormalDistribution;

public class MATH929Test {

    @Test
    public void userDescTest() {
    assertEquals(
        0.398942280401433,
        new MultivariateNormalDistribution(new double[]{0},
                new double[][]{{1}}).density(new double[]{0}), 1e-15);
    }
}
