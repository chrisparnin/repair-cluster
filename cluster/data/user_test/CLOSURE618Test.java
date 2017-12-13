/**
 * Created by waddl on 8/20/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE618Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "function f() {\n" +
                "    var a = [], b;\n" +
                "    a.push(b = []);\n" +
                "    b[0] = 1;\n" +
                "    return a;\n" +
                "    }";
        String e = "function f(){var a=[],b;a.push(b=[]);b[0]=1;return a};";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}
