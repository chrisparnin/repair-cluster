import org.apache.commons.math.linear.OpenMapRealVector;
import org.apache.commons.math.linear.RealVector;
import org.junit.Test;

public class MATH645Test {
    @Test
    public void userDescTest() {
        final RealVector u = new OpenMapRealVector(3, 1E-6);
        u.setEntry(0, 1.);
        u.setEntry(1, 0.);
        u.setEntry(2, 2.);
        final RealVector v = new OpenMapRealVector(3, 1E-6);
        v.setEntry(0, 0.);
        v.setEntry(1, 3.);
        v.setEntry(2, 0.);
        System.out.println(u);
        System.out.println(v);
        System.out.println(u.ebeMultiply(v));
    }
}
