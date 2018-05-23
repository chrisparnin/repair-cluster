import org.apache.commons.math.optimization.direct.*;
import org.apache.commons.math.FunctionEvaluationException;
import org.apache.commons.math.analysis.MultivariateRealFunction;
import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.junit.Test;
import static org.junit.Assert.*;


public class MATH283Test
{
    @Test
    public void testMultiDirectionalIncorrectStart()
        throws FunctionEvaluationException, OptimizationException
    {
        // works fine
        try
        {
            testMultiDirectionalWithStart(0.1, 0.1);
        }
        catch(Exception e) { fail(e.getMessage()); }
    }

    @Test
    public void testMultiDirectionalCorrectStart()
        throws FunctionEvaluationException, OptimizationException
    {
        // fails because MultiDirectional.iterateSimplex is looping forever
        // the while(true) should be replaced with a convergence check
        try
        {
            testMultiDirectionalWithStart(0.0, 0.0);
        }
        catch(Exception e) { fail(e.getMessage()); }

    }



    private void testMultiDirectionalWithStart(double xStart, double yStart)
        throws FunctionEvaluationException, OptimizationException
    {
        MultiDirectional multiDirectional = new MultiDirectional();
        multiDirectional.setMaxIterations(100);
        multiDirectional.setMaxEvaluations(1000);

        final Gaussian2D function = new Gaussian2D();

        RealPointValuePair estimate = multiDirectional.optimize(function,
                                      GoalType.MAXIMIZE, new double[] {xStart, yStart} );

        final double EPSILON = 1e-5;

        final double expectedMaximum = function.getMaximum();
        final double actualMaximum = estimate.getValue();
        assertEquals(expectedMaximum, actualMaximum, EPSILON);

        final double[] expectedPosition = function.getMaximumPosition();
        final double[] actualPosition = estimate.getPoint();
        assertEquals(expectedPosition[0], actualPosition[0], EPSILON );
        assertEquals(expectedPosition[1], actualPosition[1], EPSILON );
        
    }

    static class Gaussian2D implements MultivariateRealFunction
    {
        private static final double[] maximumPosition = { 0, 0 };

        private final double std = 1;
       
        public double getMaximum()
        {
            return value(maximumPosition);
        }

        public double[] getMaximumPosition()
        {
            return maximumPosition.clone();
        }

        public double value(double[] point)
        {
            final double x = point[0], y = point[1];

            return 1/(2*Math.PI*std*std)*Math.exp(-(x*x + y*y) / (2*std*std));
        }
    }
}
