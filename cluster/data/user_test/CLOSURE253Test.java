import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE253Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        // Headers break programmatic call without
//        String s = "// ==ClosureCompiler==" +
//                "// @output_file_name default.js" +
//                "// @compilation_level SIMPLE_OPTIMIZATIONS" +
//                "// @language_in ECMASCRIPT5" +
//                "// @language_out ECMASCRIPT5" +
//                "// ==/ClosureCompiler== " +
//                "function foo (bar, baz) {" +
//                "   return bar;" +
//                "} " +
//                "alert (foo.length);";
        String s = "function foo (bar, baz) {" +
                "   return bar;" +
                "} " +
                "alert (foo.length);";
        // expected result (given by user)
        String e = "function foo(a,b){return a}alert(foo.length);";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}

/* INFO
// ==ClosureCompiler==
// @output_file_name default.js
// @compilation_level SIMPLE_OPTIMIZATIONS
// ==/ClosureCompiler==

function foo (bar, baz) {
    return bar;
}
alert (foo.length);

// Expected:
// function foo(a,b){return a}alert(foo.length);
// Result:
// function foo(a){return a}alert(foo.length);
 */
