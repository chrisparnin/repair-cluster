/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.lang.model.element.*;
import java.lang.CharSequence;

public class LANG786Test {
    @Test // direct from user
    public void userTest(){
        CharSequence cs = "foo";
        String s = "foo";
        //Element e = "foo";
        assertTrue(StringUtils.equals(cs, cs));
        assertTrue(StringUtils.equals(cs, (CharSequence) s));
        assertTrue(StringUtils.equals(cs, s));
        //assertTrue(StringUtils.equals(cs, (CharSequence) new javax.lang.model("foo")));
        // TODO: If this doesn't work, how to get model.element.name to compare???
    }
}
