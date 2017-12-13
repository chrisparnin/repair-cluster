/**
 * Created by waddl on 2/7/2017.
 */
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigInteger;

public class LANG747Test {
    @Test
    public void userDescTest() {
        // User comments that: "createNumber() still does not handle 8-digit hex longs (e.g.: "0x80000000")."
        assertEquals(Long.valueOf(0x80000000L), NumberUtils.createNumber("0x80000000"));

        // TODO Note: this should always fail since it is signed
        // TODO Note: dev also finds that the current code incorrectly assumed that any 8 digit hex is valid
        // assertEquals(Integer.valueOf(0x80000000), NumberUtils.createNumber("0x8000000"));
        // System.out.println(NumberUtils.createNumber("0x80000000"));  // 2147483648
        // System.out.println(Integer.valueOf(0x80000000));  // -2147483648
    }

    // @Test
    // public void patchTest1() {
    //     assertEquals(Integer.valueOf(0x8000),      NumberUtils.createNumber("0x8000"));
    //     assertEquals(Integer.valueOf(0x80000),     NumberUtils.createNumber("0x80000"));
    //     assertEquals(Integer.valueOf(0x800000),    NumberUtils.createNumber("0x800000"));
    //     assertEquals(Integer.valueOf(0x8000000),   NumberUtils.createNumber("0x8000000"));
    //     assertEquals(Integer.valueOf(0x7FFFFFFF),  NumberUtils.createNumber("0x7FFFFFFF"));
    //     assertEquals(Long.valueOf(0x80000000L),    NumberUtils.createNumber("0x80000000"));
    //     assertEquals(Long.valueOf(0xFFFFFFFFL),    NumberUtils.createNumber("0xFFFFFFFF"));
    //
    //     // Leading zero tests
    //     assertEquals(Integer.valueOf(0x8000000),   NumberUtils.createNumber("0x08000000"));
    //     assertEquals(Integer.valueOf(0x7FFFFFFF),  NumberUtils.createNumber("0x007FFFFFFF"));
    //     assertEquals(Long.valueOf(0x80000000L),    NumberUtils.createNumber("0x080000000"));
    //     assertEquals(Long.valueOf(0xFFFFFFFFL),    NumberUtils.createNumber("0x00FFFFFFFF"));
    //
    //     assertEquals(Long.valueOf(0x800000000L),        NumberUtils.createNumber("0x800000000"));
    //     assertEquals(Long.valueOf(0x8000000000L),       NumberUtils.createNumber("0x8000000000"));
    //     assertEquals(Long.valueOf(0x80000000000L),      NumberUtils.createNumber("0x80000000000"));
    //     assertEquals(Long.valueOf(0x800000000000L),     NumberUtils.createNumber("0x800000000000"));
    //     assertEquals(Long.valueOf(0x8000000000000L),    NumberUtils.createNumber("0x8000000000000"));
    //     assertEquals(Long.valueOf(0x80000000000000L),   NumberUtils.createNumber("0x80000000000000"));
    //     assertEquals(Long.valueOf(0x800000000000000L),  NumberUtils.createNumber("0x800000000000000"));
    //     assertEquals(Long.valueOf(0x7FFFFFFFFFFFFFFFL), NumberUtils.createNumber("0x7FFFFFFFFFFFFFFF"));
    //     // N.B. Cannot use a hex constant such as 0x8000000000000000L here as that is interpreted as a negative long
    //     assertEquals(new BigInteger("8000000000000000", 16), NumberUtils.createNumber("0x8000000000000000"));
    //     assertEquals(new BigInteger("FFFFFFFFFFFFFFFF", 16), NumberUtils.createNumber("0xFFFFFFFFFFFFFFFF"));
    //
    //     // Leading zero tests
    //     assertEquals(Long.valueOf(0x80000000000000L),   NumberUtils.createNumber("0x00080000000000000"));
    //     assertEquals(Long.valueOf(0x800000000000000L),  NumberUtils.createNumber("0x0800000000000000"));
    //     assertEquals(Long.valueOf(0x7FFFFFFFFFFFFFFFL), NumberUtils.createNumber("0x07FFFFFFFFFFFFFFF"));
    //     // N.B. Cannot use a hex constant such as 0x8000000000000000L here as that is interpreted as a negative long
    //     assertEquals(new BigInteger("8000000000000000", 16), NumberUtils.createNumber("0x00008000000000000000"));
    //     assertEquals(new BigInteger("FFFFFFFFFFFFFFFF", 16), NumberUtils.createNumber("0x0FFFFFFFFFFFFFFFF"));
    // }
}
