import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE884Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "/** @interface \n" +
                "* @extends {unknown_1} \n" +
                "* @extends {unknown_2} \n" +
                "*/ function Foo() {}";
        // expected result (given by user)
        String e = ""; // No compiled code because there were warnings.

        String[] expectedWarnings = {
                "Bad type annotation. Unknown type unknown_1",
                "Bad type annotation. Unknown type unknown_2"};
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

/* INFO
Closure 884
[Given by user]
SIMPLE_OPTIMIZATIONS
Given:
/**
* @interface
* @extends {unknown_1}
* @extends {unknown_2}
(end comment)
function Foo() {}
Result:
        java.lang.NullPointerException ... (stack trace)
        User comment: Seems like a combination of @interface plus more than one @extend and where at least one of the @extend types are unknown causes a crash.
        Dev comment: Great! Thanks for the tiny reproduction example
*/
