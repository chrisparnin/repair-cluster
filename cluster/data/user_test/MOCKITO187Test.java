import junit.framework.AssertionFailedError;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.InvocationOnMock;

public class MOCKITO187Test extends Mockito 
{
    public interface TestMock {
        public boolean m1();
    };

    @Test
    public void test() {
        TestMock test = mock(TestMock.class, new Answer() {
            @Override public Object answer(InvocationOnMock invocation) throws Throwable {
                return false;
            }
        });
        try
        {
            test.m1();
            verifyZeroInteractions(test);
        }
        catch( Error ex )
        {
            // verifyZeroInteractions will throw exception (correct).
            //AssertionFailedError
            assertTrue("verifyZeroInteractions will throw exception (correct)", true);
        }
        catch( ClassCastException ex)
        {
            Assert.fail("Fix should not throw this");
        }
    }
}
