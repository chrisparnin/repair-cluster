import org.junit.Test;
import org.mockito.exceptions.base.MockitoException;
import static org.mockito.Mockito.*;

public class MOCKITO140Test {

    private interface Fake { public boolean doStuff(); }

    @Test (expected = MockitoException.class)
    public void failFast() {
        Fake mockOfAnIterface = mock(Fake.class);
        when(mockOfAnIterface.doStuff()).thenCallRealMethod();
    }
}

