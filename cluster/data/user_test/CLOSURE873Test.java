import org.junit.Test;
import static org.junit.Assert.*;

public class CLOSURE873Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "/**\n" +
                "* @param {*} object Any object.\n" +
                "* @return {boolean}\n" +
                "*/\n" +
                "test.isMatched = function(object) {\n" +
                "    if (goog.isDef(object)) {\n" +
                "        if (goog.isFunction(object)) {\n" +
                "            // return object();\n" +
                "        } else if (goog.isBoolean(object)) {\n" +
                "            // return object;\n" +
                "        } else if (goog.isString(object)) {\n" +
                "            // return test.isDef(object);\n" +
                "        } else if (goog.isArray(object)) {\n" +
                "            var i = object.length;\n" +
                "        }\n" +
                "    }\n" +
                "    return false;\n" +
                "};";
        // expected result (given by user)
        String e = "test.isMatched=function(a){goog.isDef(a)&&!goog.isFunction(a)&&(goog.isBoolean(a)||goog.isString(a)||goog.isArray(a));return!1};";
        // actual result (given by compiler)
        try {
            String a = compile(s);
            System.out.println(a);
            // test expected vs actual
            assertEquals(e,a);
        } catch(Exception ex) {
            assertTrue(ex.getMessage(), false);
        }
    }
}

/* INFO
//Closure 873
//[Given by user]
//User title: Converting from an interface type to a constructor which @implements itself causes stack overflow.
//Given:
///** @interface */
//var OtherType = function() {}
///**  @implements {MyType}  */
///**  @constructor  */
//        var MyType = function() {}
///** @type {MyType}  */
//        var x = /** @type {!OtherType} */ (new Object());
//
//        User comment: \r\n\r\nGet Infinite recursion in:\r\n\r\nPrototypeObjectType.isSubtype
//@ 350\r\n\r\nOptions:\r\n\r\n- prevent cycles in the inheritance/implements graph\r\n- detect cycles after they are
//        created and exit compilation before any subsequent passes run\r\n- detect and remove cycles after they are
//        created but before any subsequent passes run\r\n- make every subsequent pass robust against cycles in that
// graph
