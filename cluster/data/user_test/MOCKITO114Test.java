import org.junit.Test;
import org.mockito.Mockito;
import java.lang.reflect.Method; 

import org.mockito.internal.util.reflection.GenericMetadataSupport;

import static org.mockito.internal.util.reflection.GenericMetadataSupport.inferFrom; 

import static org.assertj.core.api.Assertions.assertThat; 
//import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MOCKITO114Test {
    interface GenericsSelfReference<T extends GenericsSelfReference<T>> {
        T self();
    }

    @Test
    public void typeVariable_of_self_type() {
        GenericMetadataSupport genericMetadata = 
        inferFrom(GenericsSelfReference.class).resolveGenericReturnType(
            firstNamedMethod("self", GenericsSelfReference.class));

        //assertEquals(genericMetadata.rawType(),GenericsSelfReference.class);
        assertThat(genericMetadata.rawType()).isEqualTo(GenericsSelfReference.class);
    }

    // Internal helper method from test suite
    private Method firstNamedMethod(String methodName, Class<?> clazz) { 
        for (Method method : clazz.getMethods()) { 
            boolean protect_against_different_jdk_ordering_avoiding_bridge_methods = !method.isBridge(); 
            if (method.getName().contains(methodName) && protect_against_different_jdk_ordering_avoiding_bridge_methods) { 
                return method; 
            } 
        } 
        return null;
    } 
}
