// TODO NOTE: This fails the replication script because the original code by the user does not replicate the error.

// Hi, I think I found a bug in the DateUtils class in the method isSameLocalTime.

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import java.util.Calendar;

import org.junit.Assert;

public class LANG677Test {
    @Test  
    public void isSameLocalTimeHourTest() {
        Calendar a = Calendar.getInstance();
        a.setTimeInMillis(1297364400000L);
        
        Calendar b = Calendar.getInstance();
        b.setTimeInMillis(1297321200000L);

        //a.set(2004, 6, 9, 4,  0, 0);
 	 	//b.set(2004, 6, 9, 16, 0, 0);
 	 	//a.set(Calendar.MILLISECOND, 0);
 	 	//b.set(Calendar.MILLISECOND, 0);

        Assert.assertFalse(DateUtils.isSameLocalTime(a, b));
    }
}

// Fix
// This is because the method compares 
// cal1.get(Calendar.HOUR) == cal2.get(Calendar.HOUR)
// but I think it has to be 
// cal1.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY)
