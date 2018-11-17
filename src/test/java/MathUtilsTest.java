import org.junit.Test;
import scientific.MathUtils;

import static org.junit.Assert.assertEquals;

public class MathUtilsTest {

    @Test
    public void greatestCommonDivisorCorrectForSameNumber() {
        int greatestCommonDivisor = MathUtils.greatestCommonDivisor(13,13);
        assertEquals(13,greatestCommonDivisor);
    }

    @Test
    public void greatestCommonDivisorCorrectForPositiveNumbers() {
        int greatestCommonDivisor = MathUtils.greatestCommonDivisor(5,15);
        assertEquals(5,greatestCommonDivisor);
    }

    @Test
    public void greatestCommonDivisorCorrectFor0Value() {
        int greatestCommonDivisor = MathUtils.greatestCommonDivisor(0,5);
        assertEquals(5,greatestCommonDivisor);
    }

    @Test
    public void greatestCommonDivisorCorrectForNegativeNumbers() {
        int greatestCommonDivisor = MathUtils.greatestCommonDivisor(-15,5);
        assertEquals(5,greatestCommonDivisor);
    }

}
