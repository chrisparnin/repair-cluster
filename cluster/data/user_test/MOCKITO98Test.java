import org.junit.Test; 
import org.mockito.Mockito;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import org.mockito.exceptions.verification.WantedButNotInvoked;

public class MOCKITO98Test
{
    private static class Foo 
    { 
        public void doCall(int aValue) { return; } 
    }

    @Test (expected = WantedButNotInvoked.class)
    public void shouldNotThrowAnyException() throws Exception 
    {
        Foo foo = spy(new Foo());
        verify(foo).doCall(isA(int.class));
    }
}
