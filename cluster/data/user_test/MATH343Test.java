import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.BisectionSolver;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by waddl on 3/13/2018.
 */
public class MATH343Test {
    @Test
    public void userDescTest() {
        try {
            UnivariateRealFunction f = new SinFunction();
            new BisectionSolver().solve(f, 1, 1.5, 1.2);
            assertTrue(false);
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

