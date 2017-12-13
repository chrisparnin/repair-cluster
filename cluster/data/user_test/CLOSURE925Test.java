import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE925Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "if( es[--esi][ es[esi+1] ] === 1)\n" +
                "        {\n" +
                "            es[esi] = 0;\n" +
                "        } else {\n" +
                "            es[esi] = 1;\n" +
                "        }";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "1===es[--esi][es[esi+1]]?es[esi]=0:es[esi]=1;";
            // junit.framework.AssertionFailedError: expected:<
            // [[1===es[--esi][es[esi+1]]?es[esi]=0:es[esi]=]]1;> but was:<
            // [1===es[--esi][es[esi+1]]?es[esi]=0:es[esi]=]1;>
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
