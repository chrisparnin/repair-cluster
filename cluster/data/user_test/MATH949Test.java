import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunction;
import org.apache.commons.math3.optim.nonlinear.vector.ModelFunctionJacobian;
import org.apache.commons.math3.optim.nonlinear.vector.Target;
import org.apache.commons.math3.optim.nonlinear.vector.Weight;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.util.FastMath;

public class MATH949Test {

    @Test
    public void userDescTests() {
        // setup
        LevenbergMarquardtOptimizer otim = new LevenbergMarquardtOptimizer();

        // action
        otim.optimize(new MaxEval(100), new Target(new double[] { 1 }),
            new Weight(new double[] { 1 }), new InitialGuess(
                new double[] { 3 }), new ModelFunction(
                new MultivariateVectorFunction() {
                    @Override
                    public double[] value(double[] point) throws IllegalArgumentException {
                        return new double[] { FastMath.pow(point[0], 4) };
                    }
                }), new ModelFunctionJacobian(
                new MultivariateMatrixFunction() {
                    @Override
                    public double[][] value(double[] point) throws IllegalArgumentException {
                        return new double[][] { { 0.25 * FastMath.pow(point[0], 3) } };
                    }
                }));

        // verify
        assertTrue("Evaluations > 1", otim.getEvaluations() > 1);
        assertTrue("Iterations > 1", otim.getIterations() > 1);
    }
}
