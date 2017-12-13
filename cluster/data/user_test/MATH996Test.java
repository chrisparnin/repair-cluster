import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.fraction.*;

public class MATH996Test {
    @Test
    public void userDescTest() {
        double d = 0.5000000001;
        Fraction f = new Fraction(d, 10);
    }
}
