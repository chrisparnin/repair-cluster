import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO128Test {

    @Test
    public void discoverDeepMockingOfGenerics() {
        MyClass1 myMock1 = mock(MyClass1.class, RETURNS_DEEP_STUBS);

        when(myMock1.getNested().getNested().returnSomething()).thenReturn("Hello World.");
    }

    public static interface MyClass1 <MC2 extends MyClass2> {
        public MC2 getNested();
    }

    public static interface MyClass2<MC3 extends MyClass3> {
        public MC3 getNested();
    }

    public static interface MyClass3 {
        public String returnSomething();
    }
}
