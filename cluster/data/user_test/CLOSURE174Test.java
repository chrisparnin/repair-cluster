/**
 * Created by waddl on 8/20/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE174Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "function foo() {\n" +
                "    var arr =[1, 2, 3, 4, 5];\n" +
                "    for (var i =0, l =arr.length; i < l; i++) {\n" +
                "        var j =arr[i];\n" +
                "        (function() {\n" +
                "            var k =j;\n" +
                "            setTimeout(function() { console.log(k); }, 0);\n" +
                "            })();\n" +
                "            }\n" +
                "            }\n" +
                "            foo();";
        /*
        junit.framework.AssertionFailedError: expected:
        <...[a];(function(){var [a=d;setTimeout(function(){console.log(a])},0)})()}}foo();> but was:
        <...[a];(function(){var [e=d;setTimeout(function(){console.log(e])},0)})()}}foo();>
        <... d=b[a];(function(){[setTimeout(function(){console.log(d])},0)})()}}foo();> (bugged)
         */
        String e = "function foo(){for(var b=[1,2,3,4,5],a=0,c=b.length;a<c;a++){var d=b[a];(function(){var e=d;setTimeout(function(){console.log(e)},0)})()}}foo();";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}
