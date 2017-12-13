import static org.junit.Assert.*;

import java.util.Locale;
import org.joda.time.*;
import org.joda.time.chrono.*;
import org.joda.time.format.*;
import org.joda.time.tz.*;
import org.junit.Test;

public class TIME147Test {
    @Test
    public void userDescTest() {
        int i = -1;
        long ii = i;
        long iii = Long.MIN_VALUE;
        long nn = 256L * 256L * 256L * 256L;  // 2**32
        long v;
        String str;

        System.out.println("" );
        System.out.println("## possibly a bug in "
                    + "org.joda.time.field.FieldUtils.safeMultiply(long, int)");

        System.out.println("");
        System.out.println( "# First show some Java long arithmetic overflows");
        System.out.println( "#" );
        System.out.println( "# nn == " + nn + ", nn*nn == " + (nn * nn ));
        System.out.println( "#" );
        System.out.println( "# " + iii + " == long iii ; long ii= " + ii + " ; int i= " + i );
        System.out.println( "#  " + (iii + ii) + " == iii + ii" );
        System.out.println( "# " + (iii * ii) + " == iii * ii" );
        System.out.println( "# " + (iii / ii) + " == iii / ii" );

        System.out.println("");
        System.out.println( "# Now show safeMultiply working as expected:" );

        System.out.println( "#" );
        str = "# org.joda.time.field.FieldUtils.safeMultiply(long iii, long ii) #=>";
        System.out.println( str );
        try {
            v = org.joda.time.field.FieldUtils.safeMultiply(iii, ii);
            str = "#   " + v;
        } catch (ArithmeticException e) {
            str = "#   ERR= " + e;
        }
        System.out.println( str );

        System.out.println( "#" );
        str = "# org.joda.time.field.FieldUtils.safeMultiply(long ii, long iii) #=>";
        System.out.println( str );
        try {
            v = org.joda.time.field.FieldUtils.safeMultiply(ii, iii);
            str = "#   " + v;
        } catch (ArithmeticException e) {
            str = "#   ERR= " + e;
        }
        System.out.println( str );

        System.out.println( "#" );
        str = "# org.joda.time.field.FieldUtils.safeMultiply(int i, long iii) #=>";
        System.out.println( str );
        try {
            v = org.joda.time.field.FieldUtils.safeMultiply(i, iii);
            str = "#   " + v;
        } catch (ArithmeticException e) {
            str = "#   ERR= " + e;
        }
        System.out.println( str );

        System.out.println( "#" );
        str = "# org.joda.time.field.FieldUtils.safeMultiply(long iii, int 2) #=>";
        System.out.println( str );
        try {
            v = org.joda.time.field.FieldUtils.safeMultiply(iii, 2);
            str = "#   " + v;
        } catch (ArithmeticException e) {
            str = "#   ERR= " + e;
        }
        System.out.println( str );

        ///////////////////////////////////////////////////////////////////////////

        System.out.println( "" );
        System.out.println( "# Now show the possible bug:" );

        System.out.println( "#" );
        str = "# org.joda.time.field.FieldUtils.safeMultiply(long iii, int i) #=>";
        System.out.println( str );
        try {
            v = org.joda.time.field.FieldUtils.safeMultiply(iii, i);
            str = "#   " + v;
        } catch (ArithmeticException e) {
            str = "#   ERR= " + e;
        }
        System.out.println( str );
        assertEquals(str, "#   ERR= java.lang.ArithmeticException: Multiplication overflows a long: -9223372036854775808 * -1");
    }
}
