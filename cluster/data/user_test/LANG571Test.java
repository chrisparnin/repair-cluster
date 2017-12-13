import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.junit.Assert;
import java.lang.IllegalArgumentException;
import java.lang.Exception;

public class LANG571Test {
    @Test  
    public void ArrayUtilsShouldThrowIllegalParamException()
    {
        try
        {
            String[] sa = ArrayUtils.add(null, null);
        }
        catch( IllegalArgumentException ex )
        {
            Assert.assertTrue(true);
        }
        catch( Exception ex)
        {
            Assert.assertTrue(false);
        }        
    }
}
 
