import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE311Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "function a(b) {\n" +
                "        switch (b.v) {\n" +
                "        case 'SWITCH':\n" +
                "        if (b.i >= 0) {\n" +
                "        return b.o;\n" +
                "        } else {\n" +
                "        return undefined;\n" +
                "        }\n" +
                "        break;\n" +
                "        }\n" +
                "        }";

        // actual result (given by compiler)
        try {
            String a = compile(s);
            String e = "function a(b){switch(b.v){case \"SWITCH\":if(b.i>=0)return b.o}};";
            // junit.framework.AssertionFailedError: expected:<...v){
            // case "SWITCH":if([0<=b.i])return b.o}};> but was:<...v){
            // case "SWITCH":if([b.i>=0])return b.o}};>
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
