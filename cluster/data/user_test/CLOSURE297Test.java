import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CLOSURE297Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "function closureCompilerTest(someNode) {\n" +
                "    var nodeId;\n" +
                "    return ((nodeId=someNode.id) && (nodeId=parseInt(nodeId.substr(1))) && nodeId>0);\n" +
                "    }";
        // expected result (given by user)
        /*
        expected:
        <...eInt(a.substr(1)))&&[0<a]};> but was:
        <...eInt(a.substr(1)))&&[a>0]};>
        <...eInt(a.substr(1)))&&a>0]};>

         */
        String e = "function closureCompilerTest(b){var a;return(a=b.id)&&(a=parseInt(a.substr(1)))&&a>0};";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}
