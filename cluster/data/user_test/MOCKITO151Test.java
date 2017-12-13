import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO151Test {

    private static interface IMethods 
    {
        Object objectReturningMethodNoArgs();
    }

    @Test public void causesException() {
        IMethods mock = mock(IMethods.class, RETURNS_MOCKS); 
        when(mock.objectReturningMethodNoArgs()).thenReturn(null);    
    }
}

