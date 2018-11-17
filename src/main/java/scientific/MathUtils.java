package scientific;

import java.math.BigInteger;

public class MathUtils {

    public static int greatestCommonDivisor(int integerOne, int integerTwo) {
        BigInteger bigIntegerOne = BigInteger.valueOf(integerOne);
        BigInteger bigIntegerTwo = BigInteger.valueOf(integerTwo);
        return bigIntegerOne.gcd(bigIntegerTwo).intValue();
    }

    public static int lowestCommonMultiple(int integerOne, int integerTwo) {
        return integerOne * (integerTwo/greatestCommonDivisor(integerOne,integerTwo));
    }

    public static boolean isPrime(int valueToCheckIfPrime) {
        if(valueToCheckIfPrime <= 3 && valueToCheckIfPrime > 1) {
            return true;
        } else if(valueToCheckIfPrime % 2 == 0 || valueToCheckIfPrime % 3 == 0) {
            return false;
        } else {
            for (int valueToCheckIfDivisibleBy = 5; Math.pow(valueToCheckIfDivisibleBy,2) <= valueToCheckIfPrime; valueToCheckIfDivisibleBy+=6) {
                if(valueToCheckIfPrime % valueToCheckIfDivisibleBy == 0 || valueToCheckIfPrime%(valueToCheckIfDivisibleBy + 2) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
