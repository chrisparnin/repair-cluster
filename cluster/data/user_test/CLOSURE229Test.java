import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE229Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "        /**\n" +
                "        * @param {...string} var_args\n" +
                "        */\n" +
                "        function foo(var_args) {\n" +
                "            return arguments.length;\n" +
                "        }\n" +
                "        foo('hello'); // no warning - ok\n" +
                "        //foo(123); // warning - ok\n" +
                "        foo('hello', 123); // no warning! error.";
        // expected result (given by user)
        String e = ""; // No compiled code because there were warnings.

        String[] expectedWarnings = {
                "JSC_TYPE_MISMATCH: actual parameter 2 of foo does not match formal parameter"};
        // actual result (given by compiler)
        try {
            String a = compile(s, false, expectedWarnings, null);
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
