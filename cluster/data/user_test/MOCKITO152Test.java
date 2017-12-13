import org.testng.annotations.Test;
import java.util.Observable;
import static org.mockito.Mockito.*;

public class MOCKITO152Test {
    @Test public void should_not_throw_VerifyError() {
        verify(mock(Observable.class), timeout(500)).countObservers();
    }
}
