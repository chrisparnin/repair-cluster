import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE113Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = " function instanceOf(value, type) {\n" +
                "            try {\n" +
                "                // first try built-in test -- if it succeeds, we're golden.\n" +
                "                if (value instanceof type) {\n" +
                "                    return true;\n" +
                "                    }\n" +
                "                } catch (exception) {\n" +
                "                    if (exception instanceof TypeError) {\n" +
                "                        throw exception; // indicates that \"type\" is not a type\n" +
                "                        }\n" +
                "                    // Otherwise, assume the exception was caused by\n" +
                "                    // the Firefox 1.0.3 bug.  Work around it.\n" +
                "                     return (type === Object);\n" +
                "                     }\n" +
                "                    }";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "function instanceOf(c,a){try{if(c instanceof a)return true}catch(b){if(b instanceof TypeError)throw b;return a===Object}};"; //no warnings, no errors
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
