/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang.math.*;  // 2.6 version fix
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

/* USER COMMENT
We've have tested it in a JUnit with the following string: "0.9090909090909091", that debugging it returns a float
with the value 0.90909094, which clearly is wrong. That's why we thought the approach for the conversion is wrong.
Did you tried to debug it just to be sure that the execution flow is going as you expect?
 */
public class LANG693Test {
    @Test
    public void userDescTest() {
        assertEquals(Float.valueOf("0.9090909090909091").toString(),
                NumberUtils.createNumber("0.9090909090909091").toString());
        assertEquals(Double.valueOf("0.9090909090909091").toString(),
                NumberUtils.createNumber("0.9090909090909091").toString());
        assertEquals(BigDecimal.valueOf(0.9090909090909091).toString(),
                NumberUtils.createNumber("0.9090909090909091").toString());
    }
    // @Test
    // public void patchTest1() {
    //     String shouldBeFloat = "1.23";
    //     String shouldBeDouble = "3.40282354e+38";
    //     String shouldBeBigDecimal = "1.797693134862315759e+308";
    //     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float);
    //     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double);
    //     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal);
    //     assertEquals("createNumber(String) LANG-693 failed", Double.valueOf(Double.MAX_VALUE), NumberUtils
    //             .createNumber("" + Double.MAX_VALUE));
    // }
}
