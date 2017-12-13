import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE769Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "goog.isFunction(this)\n" +
                "goog.isObject(this)\n" +
                "goog.isNull(this)";
        // expected result (given by user)
        String e = "goog.isFunction(this);goog.isObject(this);goog.isNull(this);"; // No compiled code because there were warnings.

        String[] expectedErrors = {};
        // actual result (given by compiler)
        try {
            String a = compile(s, true, null, expectedErrors);
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
