import org.junit.Test;

import static org.mockito.internal.matchers.Equality.areEqual;

public class MOCKITO484Test {

    private final class BadEquals { @Override public boolean equals (Object oth) { throw new RuntimeException(); } }

    @Test public void doNotCallUnderlyingEquals() {
        Object badequals=new BadEquals();
        areEqual(badequals,badequals);
    }
}



