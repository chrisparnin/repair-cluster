import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MOCKITO188Test {

    public static class MockitoExample {
        private MockitoExampleExecutor executor;
        public void execute(){
            executor.execute("var1",new Date());
        }
    }
    public class MockitoExampleExecutor {
        public void execute(Object... bindVariables){}
    }

    @Mock
    private MockitoExampleExecutor mockitoExampleExecutor;
    @Captor
    private ArgumentCaptor<Date> dateCaptor;
    @InjectMocks
    private MockitoExample subject;

    @Test
    public void testThat_Execute_InvokesCalendar() throws Exception {
        subject.execute();
        verify(mockitoExampleExecutor).execute( eq("var1"), dateCaptor.capture());
        assertNotNull(dateCaptor.getValue());
    }
}
