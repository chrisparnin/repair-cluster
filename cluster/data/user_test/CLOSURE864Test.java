import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE864Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "function getStack() {"+
                "var getErrorObject = function() {" +
                "try {"+
                "    throw Error(\"\");" +
                "} catch(err) {" +
                "return err;" +
                "}" +
                "};" +
                "return getErrorObject().stack;" +
                "}" +
                "window['getStackTrace']=getStack;";
        // expected result (given by user)
        String e = "function getStack(){var a;try{throw Error(\"\");}catch(b){a=b}return a.stack}window.getStackTrace=getStack;";
        // junit.framework.AssertionFailedError: expected:<
        // function getStack(){[try{throw Error("");}catch(a){var b=a}return b].stack}window.getSta...> but was:<
        // function getStack(){[var a;try{throw Error("");}catch(b){a=b}return a].stack}window.getSta...>
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}

/* INFO
Closure 864
[Given by user]
Given:
function getStack() {
    var getErrorObject = function() {
        try {
            throw Error("");
        } catch(err) {
            return err;
        }
    };
    return getErrorObject().stack;
}\r\nwindow[\u0027getStackTrace\u0027]\u003dgetStack;\r\n\r\n
Result:
Use Optimization \u003d Simple. Note the following result:\r\n\r\n
function getStack() {
    try {
        throw Error("");
    } catch(a) {}
    return a.stack
}
\r\nwindow.getStackTrace \u003d getStack;\r\n\r\n
User comment: The scope of the variable a is limited to the catch clause, but the compiler references it illegally as the return value of the inlined function.
Dev comment: Thanks for the report and the reduced test case.  It looks like the \"flow sensitive variable inliner\" is causing this problem.
*/
