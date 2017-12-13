import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.events.EventHandler;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

public class MATH950Test {

    @Test
    public void userDescTests() {
       FirstOrderDifferentialEquations sincos = new FirstOrderDifferentialEquations() {
           public int getDimension() {
               return 2;
           }
 
           public void computeDerivatives(double t, double[] y, double[] yDot) {
               yDot[0] =  y[1];
               yDot[1] = -y[0];
           }
 
       };
 
       SchedulingChecker sinChecker = new SchedulingChecker(0);
       SchedulingChecker cosChecker = new SchedulingChecker(1);
 
       FirstOrderIntegrator integ = new DormandPrince853Integrator(0.001, 1.0, 1.0e-12, 0.0);
       integ.addEventHandler(sinChecker, 0.01, 1.0e-7, 100);
       integ.addStepHandler(sinChecker);
       integ.addEventHandler(cosChecker, 0.01, 1.0e-7, 100);
       integ.addStepHandler(cosChecker);
       double   t0 = 0.5;
       double[] y0 = new double[] { FastMath.sin(t0), FastMath.cos(t0) };
       double   t  = 10.0;
       double[] y  = new double[2];
       integ.integrate(sincos, t0, y0, t, y);
   }
 
   private static class SchedulingChecker implements StepHandler, EventHandler {
       int index;
       double tMin;
 
       public SchedulingChecker(int index) {
           this.index = index;
       }
 
       public void init(double t0, double[] y0, double t) {
           tMin = t0;
       }
 
       public void handleStep(StepInterpolator interpolator, boolean isLast) {
           tMin = interpolator.getCurrentTime();
       }
 
       public double g(double t, double[]  y) {
           // once a step has been handled by handleStep,
           // events checking should only refer to dates after the step
           assertTrue(t >= tMin);
           return y[index];
       }
 
       public Action eventOccurred(double t, double[] y, boolean increasing) {
           return Action.RESET_STATE;
       }
 
       public void resetState(double t, double[] y) {
           // in fact, we don't need to reset anything for the test
       }
   }
}
