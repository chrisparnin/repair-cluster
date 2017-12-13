import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

import org.mockito.internal.util.MockUtil;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

public class MOCKITO216Test
{
    @Spy List myspy1 = new ArrayList();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fieldNameShouldBeUsedForSpy() {											      
        MockUtil util = new MockUtil();
        assertEquals("myspy1",util.getMockName(myspy1).toString());
    }
}
