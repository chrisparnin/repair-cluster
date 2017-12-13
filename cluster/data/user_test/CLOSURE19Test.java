import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE19Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "var a = {}; a.b = function() {},a.b();";
        // expected result (given by user)
        String e = "var a={};a.b=function(){};a.b();";
// junit.framework.AssertionFailedError: expected:
// <var a={[b:function(){}]};a.b();>
// but was:
// <var a={[};a.b=function(){]};a.b();>
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

