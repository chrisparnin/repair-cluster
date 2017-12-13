//import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO134Test {

    public interface TestMock {
        public Integer m1(Object o);
    };

    @Test public void anyStringBehavior() {
        //Function<Object, Integer> function = Mockito.mock(Function.class);
        TestMock mock = Mockito.mock(TestMock.class);
        when(mock.m1(Mockito.anyString())).thenReturn(1);
        Integer result = mock.m1(2);
        assertTrue("Not 1", result != 1);
    }
}
