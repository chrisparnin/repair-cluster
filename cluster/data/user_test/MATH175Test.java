import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.stat.inference.*;

public class MATH175Test {

    @Test
    public void userDescTest() {
        long[] observed1 = { 500, 623, 72, 70, 31 };
        double[] expected1 = { 521.19403, 581.37313, 88.11940, 65.5524, 39.76119 };

        ChiSquareTestImpl testStatistic = new ChiSquareTestImpl();

        assertEquals(9.023284446335818, testStatistic.chiSquare(expected1, observed1), 1E-10);
    }
}
