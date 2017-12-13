import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CLOSURE773Test extends ClosureHarness {
    @Test
    public void userDescTest() {
        String s = "var customData = { key: 'value' };\n" +
                "function testRemoveKey( key ) {\n" +
                "    var dataSlot = customData,\n" +
                "    retval = dataSlot && dataSlot[ key ],\n" +
                "    hadKey = dataSlot && ( key in dataSlot );\n" +
                "    if ( dataSlot )\n" +
                "    delete dataSlot[ key ];\n" +
                "    return hadKey ? retval : null;\n" +
                "    };\n" +
                "    console.log( testRemoveKey( 'key' ) ); // 'value'\n" +
                "    console.log( 'key' in customData ); // false";
        // expected result (given by user)
        String e = "var customData={key:\"value\"};function testRemoveKey(b){var a=customData,c=a&&a[b],d=a&&b in a;a&&delete a[b];return d?c:null}console.log(testRemoveKey(\"key\"));console.log(\"key\"in customData);";
        // actual result (given by compiler)
        String a = compile(s);
        System.out.println(a);
        // test expected vs actual
        assertEquals(e,a);
    }
}
