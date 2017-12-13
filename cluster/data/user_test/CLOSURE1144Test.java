import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE1144Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "var goog = {};\n" +
                "goog.scope;\n" +
                "var ns = {};\n" +
                "ns.sub = {};\n" +
                "/** @constructor */\n" +
                "ns.sub.C = function() {};\n" +
                "goog.scope(function() {\n" +
                "    var sub = ns.sub;\n" +
                "    /** @type {sub.C} */\n" +
                "    var x = null;\n" +
                "});";
        // expected result (given by user)
        String e = "var $jscomp={scope:{}},goog={};goog.scope;var ns={sub:{}};ns.sub.C=function(){};$jscomp.scope.x=null;";
        // junit.framework.AssertionFailedError: expected:<
        // var $jscomp=[$jscomp||{};$jscomp.scope={};var ]goog={};goog.scope;v...> but was:<
        // var $jscomp=[{scope:{}},]goog={};goog.scope;v...>
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
produces:\r\n\r\njava.lang.IllegalStateException at
com.google.common.base.Preconditions.checkState(Preconditions.java:137)
 */
