import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE1111Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "goog.scope(function() {\n" +
                "    /** @private */\n" +
                "    function test() {}\n" +
                "});";
        // expected result (given by user)
        String e = "var $jscomp={scope:{}};$jscomp.scope.test=function(){};";
        // junit.framework.AssertionFailedError: expected:<
        // var $jscomp=[[{scope:{}]]};$jscomp.scope.test...> but was:<
        // var $jscomp=[{scope:{}]};$jscomp.scope.test...>

        // actual result (given by compiler)
        try {
            String a = compile(s);
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}

/*
The code above gives an error \u0026quot;The local variable test is in a goog.scope and is not an alias.
\u0026quot;\r\n\r\nWhat is the expected output?\r\n\r\nThe code above should compile, and function test()
be referenceable only from inside the file in question. If I replace \u0026quot;function test\u0026quot;
with \u0026quot;var test \u003d function\u0026quot;, the code compiles."
 */
