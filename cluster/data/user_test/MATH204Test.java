import org.apache.commons.math.analysis.*;
import org.apache.commons.math.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class MATH204Test {
    @Test
    public void userDescTest() {
        UnivariateRealSolver solver =
                new BrentSolver(new UnivariateRealFunction() {
                    public double value(double x) throws FunctionEvaluationException {
                        return Math.sin(x);
                    }
                });
        try {
            solver.solve(0.0,10000);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
