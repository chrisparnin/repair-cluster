import java.util.Iterator;

import org.junit.Test; 
import org.mockito.Mockito;
import org.junit.Assert;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO200Test
{
    protected interface MyIterable<T> extends Iterable<T> {
        public MyIterator<T> iterator();
    }

    protected interface MyIterator<T> extends Iterator<T> {
        // adds nothing here
    }

    MyIterator<String> myIterator = Mockito.mock(MyIterator.class);
    MyIterable<String> iterable = Mockito.mock(MyIterable.class);

    @Test
    public void shouldStubbingWork() {
        Mockito.when(iterable.iterator()).thenReturn(myIterator);
        Assert.assertNotNull(((Iterable) iterable).iterator());
        Assert.assertNotNull(iterable.iterator());
    }

    @Test
    public void shouldVerificationWorks() {
        iterable.iterator();

        verify(iterable).iterator();
        verify((Iterable) iterable).iterator();
    }
}
