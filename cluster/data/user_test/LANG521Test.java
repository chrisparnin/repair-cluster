
/*NumberUtils.isNumber() should return true for a valid number ending in a trailing decimal place; e.g., "2." should be considered a number because new BigDecimal("2.") works fine. This could be done by adding the code below after line 1444, which is the if (chars[i] == 'e' || chars[i] == 'E') block.
if (chars[i] == '.') {
if (hasDecPoint || hasExp)
{ // two decimal points or dec in exponent return false; }
return foundDigit; // single trailing decimal point after non-exponent is ok
}
*/

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.junit.Assert;

public class LANG521Test {
    @Test  
    public void isNumberShouldIncludeTrailingDecimals()
    {
        Assert.assertTrue(NumberUtils.isNumber("2."));
    }
}
