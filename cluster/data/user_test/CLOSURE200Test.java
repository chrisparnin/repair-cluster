import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE200Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "i = -1 >>> 0;";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "i=4294967295;";
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
