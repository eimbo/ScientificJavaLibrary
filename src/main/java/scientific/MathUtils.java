package scientific;

import java.math.BigInteger;

public class MathUtils {

    public static int greatestCommonDivisor(int integerOne, int integerTwo) {
        BigInteger bigIntegerOne = BigInteger.valueOf(integerOne);
        BigInteger bigIntegerTwo = BigInteger.valueOf(integerTwo);
        return bigIntegerOne.gcd(bigIntegerTwo).intValue();
    }

}
