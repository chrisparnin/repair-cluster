import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.commons.lang3.*;

public class LANG703Test {
    @Test
    public void userDescTest() {
        assertEquals("null", StringUtils.join(new Object[]{
                new Object() {
                    @Override
                    public String toString() {
                        return null;
                    }
                }
        }, ','));
    }

}
