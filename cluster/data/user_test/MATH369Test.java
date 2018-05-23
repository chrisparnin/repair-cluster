import org.apache.commons.math.analysis.UnivariateRealFunction;
import org.apache.commons.math.analysis.solvers.BisectionSolver;
import org.apache.commons.math.analysis.SinFunction;
import org.apache.commons.math3.analysis.function.Sin;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MATH369Test {
        @Test
        public void userDescTest() {
            try {
                UnivariateRealFunction f = new SinFunction();
                new BisectionSolver().solve(f, 0.0, 1.0, 0.5);
            } catch (NullPointerException npe) {
                assertTrue(false);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

