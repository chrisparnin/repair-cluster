import org.apache.commons.math.ode.DerivativeException;
import org.apache.commons.math.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math.ode.IntegratorException;
import org.apache.commons.math.ode.nonstiff.DormandPrince853Integrator;
import org.junit.Assert;
import org.junit.Test;


public class MATH358Test {
    @Test
    public void userDescTest() throws IntegratorException, DerivativeException {
        final double t0 = 1878250320.0000029;
        final double t =  1878250379.9999986;
        FirstOrderDifferentialEquations ode = new FirstOrderDifferentialEquations() {

            public int getDimension() {
                return 1;
            }

            public void computeDerivatives(double t, double[] y, double[] yDot)
                    throws DerivativeException {
                yDot[0] = y[0] * 1.0e-6;
            }
        };

        DormandPrince853Integrator integrator = new DormandPrince853Integrator(0.0, 100.0,
                1.0e-10, 1.0e-10);

        double[] y = { 1.0 };
        integrator.setInitialStepSize(60.0);
        double finalT = integrator.integrate(ode, t0, y, t, y);
        Assert.assertEquals(t, finalT, 1.0e-6);
    }
}
