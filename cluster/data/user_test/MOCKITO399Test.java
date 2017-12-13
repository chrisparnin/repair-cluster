import org.junit.Test; 
import org.mockito.Matchers; 
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream; 
import java.io.ObjectOutputStream; 
import java.util.Map;

public class MOCKITO399Test 
{
    @Test 
    public void name() throws Exception 
    { 
        Map map = Mockito.mock(Map.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(map.entrySet().contains(Matchers.anyString())).thenReturn(false);
        ByteArrayOutputStream serialized = new ByteArrayOutputStream();
        new ObjectOutputStream(serialized).writeObject(map);
    } 
}
