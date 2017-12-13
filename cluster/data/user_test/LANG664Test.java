import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class LANG664Test {

    @Test  
    public void checkIsDecimalLongFormat() {
        assertFalse( NumberUtils.isNumber("1.1L") );
    }
}
