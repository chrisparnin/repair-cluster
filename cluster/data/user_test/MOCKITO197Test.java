import java.lang.Runnable;
import java.lang.NullPointerException;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.FriendlyReminderException;

public class MOCKITO197Test {

    @Test(expected = FriendlyReminderException.class)
    public void TestNegativeTimeout()
    {
        Runnable runnable = Mockito.mock(Runnable.class);
        Mockito.verify(runnable, Mockito.never()).run(); // passes as expected
        Mockito.verify(runnable, Mockito.after(1000).never()).run(); // passes as expected
        Mockito.verify(runnable, Mockito.after(-1000).atLeastOnce()).run(); // passes incorrectly
        Assert.fail("No Exception");
    }
}
