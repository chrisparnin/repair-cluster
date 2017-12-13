import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO210Test {

    interface Foo { Iterable iterableBar(); }

    @Test public void ensureIterableIsEmptyByDefault() {
        Foo foo = mock(Foo.class);
        assertNotEquals(foo.iterableBar(), null);
    }
}

