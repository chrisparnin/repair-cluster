import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.*;
import org.apache.commons.math.distribution.*;

public class MATH414Test {

    @Test
    public void userDescTest() {
        final NormalDistribution nd = new NormalDistributionImpl();
        for (int i = 0; i < 500; i++) {
            final double val = Math.exp(i);
            try {
                System.out.println("val = " + val + " cumulative = " + nd.cumulativeProbability(val));
            } catch (MathException e) {
                 e.printStackTrace();
                 fail();
            }
        }
    }
}
