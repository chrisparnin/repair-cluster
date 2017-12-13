/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import static org.junit.Assert.*;
public class LANG788Test {
    @Test // direct from user
    public void primitiveTypeClassSerialization(){
        Class<?> primitiveType = int.class;

        Class<?> clone = SerializationUtils.clone(primitiveType);
        assertEquals(primitiveType, clone);
    }
}
