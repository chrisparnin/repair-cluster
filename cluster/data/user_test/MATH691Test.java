import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.stat.descriptive.*;
import org.apache.commons.math.stat.descriptive.moment.*;

public class MATH691Test {
    @Test
    public void userDescTest() {
        int[] scores = {1, 2, 3, 4};
        SummaryStatistics stats = new SummaryStatistics();
        stats.setVarianceImpl(new Variance(false)); //use "population variance"
        for(int i : scores) {
            stats.addValue(i);
        }
        double sd = stats.getStandardDeviation();
        assertNotEquals(Double.NaN, sd);
    }
}
