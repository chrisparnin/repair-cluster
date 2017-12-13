import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE700Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "/**\n" +
                "        * @param {{text: string}} opt_data\n" +
                "        * @return {string}\n" +
                "        */\n" +
                "        function temp1(opt_data) {\n" +
                "        return opt_data.text;\n" +
                "        }\n" +
                "        /**\n" +
                "         * @param {{activity: (boolean|number|string|null|Object)}} opt_data\n" +
                "         * @return {string}\n" +
                "         */\n" +
                "        function temp2(opt_data) {\n" +
                "        /** @notypecheck */\n" +
                "        function __inner() {\n" +
                "        return temp1(opt_data.activity);\n" +
                "        }\n" +
                "        return __inner();\n" +
                "        }\n" +
                "        /**\n" +
                "         * @param {{n: number, text: string, b: boolean}} opt_data\n" +
                "         * @return {string\n" +
                "         */\n" +
                "        function temp3(opt_data) {\n" +
                "        return 'n: ' + opt_data.n + ', t: ' + opt_data.text + '.';\n" +
                "        }\n" +
                "        function callee() {\n" +
                "        var output = temp3({\n" +
                "        n: 0,\n" +
                "        text: 'a string',\n" +
                "        b: true\n" +
                "        })\n" +
                "        alert(output);\n" +
                "        }\n" +
                "        callee();";
        // expected result (given by user)
        String e = "alert(\"n: 0, t: a string.\");"; // No compiled code because there were warnings.

        String[] expectedErrors = {};
        // actual result (given by compiler)
        try {
            String a = compile(s, false, null, expectedErrors);
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) { // catch null pointer
            assertTrue(ex.getMessage(), false);
        }
    }
}
