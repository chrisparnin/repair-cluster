import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CLOSURE289Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "var lastMsg;\n" +
                "var map = {};\n" +
                "var addToMap = function(key, func) {\n" +
                "    map[key] = func;\n" +
                "};\n" +
                "var f1 = function() { alert('f1'); };\n" +
                "f1.alwaysCall = true;\n" +
                "var f2 = function() { alert('f2'); };\n" +
                "addToMap('f1', f1);\n" +
                "addToMap('f2', f2);\n" +
                "var callFunctionByKey = function(key) {\n" +
                "    var f = map[key];\n" +
                "    if (f.alwaysCall) f();\n" +
                "};\n" +
                "callFunctionByKey(Math.random() > 0.5 ? 'f1' : 'f2');";

        // actual result (given by compiler)
        try {
            String a = compile(s, false, null, null);
            /*
            junit.framework.AssertionFailedError: expected:
            <...b(){alert("f1")}b.a=[!0;  a.f1=b;a.f2=function(){alert("f2")};var c=a[.5<Math.random()]?"f1":"f2"];c.a&&c()...> but was:
            <...b(){alert("f1")}b.a=[true;a.f1=b;a.f2=function(){alert("f2")};var c=a[Math.b()>0.5]?"f1":"f2"];c.a&&c()...>
            <var a={};[a.f1=function(){alert("f1")};a.f2=function(){alert("f2")};var b=a[Math.b()>0.5?"f1":"f2"];b.a&&b]();>
             */
            String e = "var a={};function b(){alert(\"f1\")}b.a=true;a.f1=b;a.f2=function(){alert(\"f2\")};var c=a[Math.b()>0.5?\"f1\":\"f2\"];c.a&&c();";
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
