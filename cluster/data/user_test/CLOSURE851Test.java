import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE851Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "(function(arg) {" +
                "var foo = {};" +
                "foo.bar = arg;" +
                "console.log(foo.bar);" +
                "delete foo.bar;" +
                "console.log(foo.bar);" +
                "})();";
        // expected result (given by user)
        String e = "(function(b){var a={};a.bar=b;console.log(a.bar);delete a.bar;console.log(a.bar)})();";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}

/* INFO
Closure 851
[Given by user]
Given:
(function(arg) {
    var foo = {};
    foo.bar = arg;
    console.log(foo.bar);
    delete foo.bar;\
    console.log(foo.bar);
})();
Result:
(function(a){console.log(a);delete a;console.log(a)})();
(no a.bar)
*/
