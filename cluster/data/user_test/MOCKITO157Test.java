
import org.junit.Test; 
import org.mockito.Mockito;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO157Test
{
    class Foo { int blah(Object... o) { return 0; } }

    @Test
    public void shouldNotThrowAnyException() throws Exception 
    {
        Foo foo = mock(Foo.class);

        when(foo.blah(anyVararg())).thenReturn(-1);

        assertEquals(-1, foo.blah("foo"));
        assertEquals(-1, foo.blah());
    }
}
