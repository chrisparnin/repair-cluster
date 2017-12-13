import java.util.Set;
import java.util.List;

import org.junit.Test; 
import org.mockito.Mockito;

public class MOCKITO230Test
{
   static interface ListSet extends List<Set> {}

    @Test
    public void testDeepMockWithClass() {
        final ListSet mock = Mockito.mock(ListSet.class, Mockito.RETURNS_DEEP_STUBS);
        final Set mock2 = mock.get(0);
    }
}
