import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.complex.*;
import java.text.ParsePosition;

public class MATH198Test {
    @Test
    public void userDescTest() {
        String source = "1 + 1";
        ParsePosition pos = new ParsePosition(0);

        ComplexFormat format = new ComplexFormat();
        format.parse(source, pos);
    }
}
