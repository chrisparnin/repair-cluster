import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO122Test 
{
    public static abstract class TestClass 
    {
        public abstract int abstractMethod();
        public int GetValue()
        {
            return 10 + this.abstractMethod();
        }
    }

    @Test
    public void whenCreateSpy_thenCreate() 
    {
        TestClass spy = Mockito.spy(TestClass.class);
     	when(spy.abstractMethod()).thenReturn(10);
    	assertEquals(20, spy.GetValue());
    }
}
