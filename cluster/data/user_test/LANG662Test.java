
import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// The greatestCommonDivisor method in class Fraction does not find the gcd of Integer.MIN_VALUE and 2^k, and this case can be triggered by taking Integer.MIN_VALUE as the numerator. Note that the case of taking Integer.MIN_VALUE as the denominator is handled explicitly in the getReducedFraction factory method.

public class LANG662Test {
    @Test  
    public void testReducedFactory_int_int() {
			// ...
			Fraction f = Fraction.getReducedFraction(Integer.MIN_VALUE, 2);
			assertEquals(Integer.MIN_VALUE / 2, f.getNumerator());
			assertEquals(1, f.getDenominator());
    }

		@Test
		public void testReduce() {
				// ...
				Fraction f = Fraction.getFraction(Integer.MIN_VALUE, 2);
				Fraction result = f.reduce();
				assertEquals(Integer.MIN_VALUE / 2, result.getNumerator());
				assertEquals(1, result.getDenominator());
		}
}
