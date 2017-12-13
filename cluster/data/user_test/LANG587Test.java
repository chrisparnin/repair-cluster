import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import org.junit.Assert;

public class LANG587Test {
    @Test  
    public void ClassUtilsToClassNPEOnNull()
    {
        Object[] objArray = new Object[]{null};
        Assert.assertEquals(1, ClassUtils.toClass(objArray).length);
    }
}
 
