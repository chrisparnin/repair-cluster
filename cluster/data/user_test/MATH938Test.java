import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

public class MATH938Test {

    @Test
    public void userDescTest() {
        // setup
        Line line = new Line(new Vector3D(1653345.6696423641, 6170370.041579291, 90000),
                             new Vector3D(1650757.5050732433, 6160710.879908984, 0.9));
        Vector3D expected = line.getDirection().negate();

        // action
        Line reverted = line.revert();

        // verify
        assertArrayEquals(expected.toArray(), reverted.getDirection().toArray(), 0);
    }
}
