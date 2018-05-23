import java.util.Collection;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

public class MATH280Test {

    @Test
    public void userTest() throws MathException {

        NormalDistribution normal = new NormalDistributionImpl(0,1);
        double result = normal.inverseCumulativeProbability(0.9772498680518209);
        
        assertEquals(2.0, result, .0000001);
    }

}
