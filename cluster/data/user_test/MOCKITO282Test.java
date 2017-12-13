import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.System;

import org.junit.Test; 
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO282Test
{
    @Test
    public void testVerboseLogging() {
        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        List mockWithLogger = mock(List.class, withSettings().verboseLogging());
        mockWithLogger.size();
        final String standardOutput = myOut.toString();
        reset(mockWithLogger);
        mockWithLogger.size();
        assertNotEquals(standardOutput,myOut.toString());
    }
}
