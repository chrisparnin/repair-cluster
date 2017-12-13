import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE747Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "console.log([console.log('hello, '), 'world!'][1]);";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "console.log([console.log(\"hello, \"),\"world!\"][1]);";
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
