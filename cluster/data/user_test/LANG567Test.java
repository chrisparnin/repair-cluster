import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// "error" is that the stack trace gives an ArrayStoreException and not a more informative exception
public class LANG567Test {
    @Test  // testing user submitted w/ stack trace
    public void userDescTest() {
        try {
        Number[] st = ArrayUtils.addAll(new Integer[]
                        {1}
                , new Long[]
                        {2L}
        );
        } catch (IllegalArgumentException expected) {
            System.out.println("Correct");
            assertEquals("correct", "correct");
        } catch (Exception unexpected) {
            System.err.println("Incorrect");
            assertEquals("correct", "incorrect");
        }
    }
    // @Test  // testing user submitted (patch from dev)
    // public void patchTest1() {
    //     Number[] n;
    //     // Valid array construction
    //     n = ArrayUtils.addAll(new Number[]{Integer.valueOf(1)}, new Long[]{Long.valueOf(2)});
    //     assertEquals(2,n.length);
    //     assertEquals(Number.class,n.getClass().getComponentType());
    //     try {
    //         // Invalid - can't store Long in Integer array
    //         n = ArrayUtils.addAll(new Integer[]{Integer.valueOf(1)}, new Long[]{Long.valueOf(2)});
    //         throw new Exception("Should have generated IllegalArgumentException");
    //     } catch (IllegalArgumentException expected) {
    //         System.out.println("Correct");
    //     } catch (Exception unexpected) {
    //         System.err.println("Incorrect");
    //     }
    // }
}
