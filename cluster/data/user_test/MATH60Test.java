import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.math.fraction.*;
import java.text.ParsePosition;

public class MATH60Test {

    @Test
    public void userDescTest() {
        ProperFractionFormat properFormat = new ProperFractionFormat();
        String source = "-1 -2 / 3";
        ParsePosition pos = new ParsePosition(0);
        Fraction actual = properFormat.parse(source, pos);
        assertNull(actual);
    }
}
