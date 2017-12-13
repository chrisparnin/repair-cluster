import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test; 
import static org.mockito.Mockito.mock;
import static org.junit.Assert.*;

public class MOCKITO467Test
{
    @Test public void shouldCompareToTreatAsEqualMocksWithTheSameReferences() 
    { 
        Date today = mock(Date.class);

        Set<Date> set = new TreeSet<Date>();
        set.add(today);
        set.add(today);

        assertEquals(1, set.size());
    }
}
