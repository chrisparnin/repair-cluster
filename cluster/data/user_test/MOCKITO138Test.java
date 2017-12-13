import org.junit.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.exceptions.verification.TooLittleActualInvocations;

public class MOCKITO138Test {
    private static interface Foo {void setFoo(String bar);}
    private static interface Bar {String getBar();}

    @Test (expected = WantedButNotInvoked.class)
    public void testVerifyFails14() 
    {
        Foo x = Mockito.mock(Foo.class);
        Bar y = Mockito.mock(Bar.class);

        String value = y.getBar();
        verify(x).setFoo(value);
    }

    @Test (expected = WantedButNotInvoked.class)
    public void testVerifyFails13()  {
        Foo foo = Mockito.mock(Foo.class);
        Bar bar = Mockito.mock(Bar.class);

        bar.getBar();
        verify(foo).setFoo(bar.getBar());
    }

    //@Test (expected = TooLittleActualInvocations.class)
    //public void testVerifyFails14() 
    //{
    //}
}
