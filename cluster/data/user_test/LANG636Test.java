/*Findbugs:
Bug: org.apache.commons.lang3.text.ExtendedMessageFormat doesn't override java.text.MessageFormat.equals(Object)
Pattern id: EQ_DOESNT_OVERRIDE_EQUALS, type: Eq, category: STYLE

This class extends a class that defines an equals method and adds fields, but doesn't define an equals method itself. Thus, equality on instances of this class will ignore the identity of the subclass and the added fields. 
Be sure this is what is intended, and that you don't need to override the equals method. Even if you don't need to override the equals method, consider overriding it anyway to document the fact that the equals method for the subclass just return the result of invoking super.equals(o).
*/

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.commons.lang3.text.FormatFactory;
import org.junit.Test;
import java.text.Format;
import java.util.Map;
import java.util.Locale;
import java.util.Collections;

import static org.junit.Assert.*;

public class LANG636Test {

    public static class EINFormatFactory implements FormatFactory {
        public Format getFormat(String name, String arguments, Locale locale) 
        {
            return null;
        }
    }

    @Test  
    public void checkImplementsEquals() {
        ExtendedMessageFormat a = new ExtendedMessageFormat("EIN: {0}", Collections.singletonMap("ein", new EINFormatFactory()));
        ExtendedMessageFormat b = new ExtendedMessageFormat("EIN: {0}");
        // set property different
        assertTrue( !a.equals(b) );
    }
}
