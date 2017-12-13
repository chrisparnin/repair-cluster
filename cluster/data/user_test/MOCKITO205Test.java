import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MOCKITO205Test {

    @Mock(name = "b2")
    private B b2;

    @InjectMocks
    private A a;

    @Test
    public void testInjection() throws Exception {
        assertNotNull(a.b2); //fails
        assertNull(a.b1); //also fails, because unexpectedly b2 mock gets injected here
    }

    static class A{
        private B b1;
        private B b2;
    }

    interface B{}
}
