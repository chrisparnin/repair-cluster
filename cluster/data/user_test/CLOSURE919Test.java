import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE919Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "/**\n" +
                "         * @return {@code foo} bar \n" +
                "         *    baz. \n" +
                "         */\n" +
                "         var x;";
        // expected result (given by user)
        String e = "var x;";

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
