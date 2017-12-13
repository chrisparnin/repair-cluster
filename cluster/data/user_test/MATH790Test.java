import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math3.stat.inference.*;

public class MATH790Test {

    @Test
    public void userDescTest() {
        MannWhitneyUTest testStatistic = new MannWhitneyUTest();
        double[] d1 = new double[1500];
        double[] d2 = new double[1500];
        for (int i = 0; i < 1500; i++) {
            d1[i] = 2 * i;
            d2[i] = 2 * i + 1;
        }
        double result = testStatistic.mannWhitneyUTest(d1, d2);
        assertTrue(result > 0.1);
    }
}
