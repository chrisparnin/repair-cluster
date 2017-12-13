import org.apache.commons.lang.text.StrBuilder;
import junit.framework.TestCase;

public class LANG294Test extends TestCase {

    public void testUserTest() {
        StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n");
        sb.deleteAll("\n%BLAH%");
        org.junit.Assert.assertEquals("\nDo more stuff\neven more stuff\n", sb.toString());
    }
    // @Test
    // // testing user submitted (patch from dev)
    // public void patchTest1() {
    //     StrBuilder sb = new StrBuilder("\n%BLAH%\nDo more stuff\neven more stuff\n%BLAH%\n");
    //     sb.deleteAll("\n%BLAH%");
    //     assertEquals("\nDo more stuff\neven more stuff\n", sb.toString());
    // }
    // @Test
    // // testing index (2nd comment determined where bug was, from dev)
    // public void patchTest2() {
    //     StrBuilder sb = new StrBuilder("onetwothree");
    //     sb.deleteFirst("three");
    //     assertEquals(-1, sb.indexOf("three"));
    // }
}
