import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.stat.regression.*;

public class MATH85Test {

    @Test
    public void userDescTest() {
        double[] y =  { 8915.102, 8919.302, 8923.502};
        double[] x =  { 1.107178495, 1.107264895, 1.107351295};
        double[] x2 = { 1.107178495E2, 1.107264895E2, 1.107351295E2};

        SimpleRegression reg = new SimpleRegression();
        for (int i = 0; i < x.length; i++) {
            reg.addData(x[i],y[i]);
        }
        assertTrue(reg.getSumSquaredErrors() >= 0.0); // OK
        reg.clear();
        for (int i = 0; i < x.length; i++) {
            reg.addData(x2[i],y[i]);
        }
        assertTrue(reg.getSumSquaredErrors() >= 0.0); // FAIL
    }
}
