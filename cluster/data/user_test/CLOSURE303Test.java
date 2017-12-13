import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE303Test extends ClosureHarnessTwo {
    @Test
    public void userDescTest() {
        String s = "/** @constructor */\n" +
                "function Foo() {\n" +
                "        var self = this;\n" +
                "        window.setTimeout(function() {\n" +
                "        window.location = self.location;\n" +
                "        }, 0);\n" +
                "        }\n" +
                "        Foo.prototype.setLocation = function(loc) {\n" +
                "        this.location = loc;\n" +
                "        };\n" +
                "        (new Foo()).setLocation('http://www.google.com/');";

        // actual result (given by compiler)
        try {
            String a = compile(s, false, null, null);
            String e = "(new function(){var c=this;window.b(function(){window.a=c.a},0)}).a=\"http://www.google.com/\";";
            //  expected:
            // <(new function(){var [a=this;window.setTimeout(function(){window.location=a.location},0)}).location]="http://www.google....> but was:
            // <(new function(){var [c=this;window.b(function(){window.a=c.a},0)}).a]="http://www.google....>
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
