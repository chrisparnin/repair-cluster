import org.junit.Test; 
import org.mockito.Mockito;
import static org.junit.Assert.*;

public class MOCKITO352Test
{
    public class A { public long getValue() { return 1; } }

    public static Class<Integer> typeof(final int expr) {
        return Integer.TYPE;
    }

    public static Class<Long> typeof(final long expr) {
        return Long.TYPE;
    }

    @Test
    public void testBoxingBehavior() {
        A a = Mockito.mock(A.class); 
        assertEquals(typeof(a.getValue()),Long.TYPE);
    }
}

