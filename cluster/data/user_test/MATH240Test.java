import java.util.Collection;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.math.util.MathUtils;

public class MATH240Test {

    @Test
    public void testFactorial() {
        for (int i = 1; i < 21; i++) {
            assertEquals((double)factorial(i), MathUtils.factorialDouble(i), Double.MIN_VALUE);
        }
    }
    
    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}


