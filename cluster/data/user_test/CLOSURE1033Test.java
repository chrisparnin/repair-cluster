import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE1033Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "window.Foo = function(A, B, C, D) {\n" +
                "        if ( A ) {\n" +
                "        if ( B ) {\n" +
                "        C = 0;\n" +
                "        } else {\n" +
                "        C = 0 in D;\n" +
                "        }\n" +
                "        while  ( C-- ) {}\n" +
                "        }\n" +
                "        }";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "window.Foo=function(b,c,a,d){if(b)for(a=c?0:(0 in d);a--;);};";
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
