/**
 * Created by waddl on 8/20/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE620Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "alert(/ / / / /);";
        String e = "alert(/ // / /);";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}
