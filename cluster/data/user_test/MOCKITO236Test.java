import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MOCKITO236Test {

    public static class TestBean {}
    public static class TestService {
        public final Object mockShouldNotGoInHere = new Object();
        public TestBean mockShouldOnlyGoInHere;
    }

    @Mock
    private TestBean mock;
    @InjectMocks
    private TestService illegalInjectionExample = new TestService();

    @Test
    public void test() {
        Assert.assertNotNull(mock);
        Assert.assertNotNull(illegalInjectionExample.mockShouldNotGoInHere);
        Assert.assertNotNull(illegalInjectionExample.mockShouldOnlyGoInHere);
        Assert.assertTrue(mock == illegalInjectionExample.mockShouldOnlyGoInHere);
        Assert.assertTrue(mock != illegalInjectionExample.mockShouldNotGoInHere);// <-- failure
    }
}
