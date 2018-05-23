import org.apache.commons.math3.optimization.fitting.HarmonicFitter;
import org.apache.commons.math3.optimization.fitting.WeightedObservedPoint;
import org.apache.commons.math3.optimization.general.LevenbergMarquardtOptimizer;

import org.junit.Test;
import org.junit.Assert;

public class MATH844Test {

    @Test
    public void testMath844() {
        final double[] y = { 0, 1, 2, 3, 2, 1,
                            0, -1, -2, -3, -2, -1,
                            0, 1, 2, 3, 2, 1,
                            0, -1, -2, -3, -2, -1,
                            0, 1, 2, 3, 2, 1, 0 };
        final int len = y.length;
        final WeightedObservedPoint[] points = new WeightedObservedPoint[len];
        for (int i = 0; i < len; i++) {
            points[i] = new WeightedObservedPoint(1, i, y[i]);
        }
        final HarmonicFitter.ParameterGuesser guesser = new HarmonicFitter.ParameterGuesser(points);
        
        final double[] guess = guesser.guess();
        final double amplitude = guess[0];
        Assert.assertFalse(Double.isInfinite(amplitude));
    }
}