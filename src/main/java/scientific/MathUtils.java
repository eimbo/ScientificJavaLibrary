package scientific;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<Integer> uniqueFactorization(int numberToFactor) {
    	
    	List<Integer> factors = new ArrayList<Integer>();
    	double squareRoot = Math.sqrt(numberToFactor);

    	if (numberToFactor == 0) { return factors;	}
    	
    	if (numberToFactor < 0) {
    		factors.add(-1);
    		numberToFactor *= -1;
    	}
 
    	while(numberToFactor % 2 == 0) {
    		factors.add(2);
    		numberToFactor /= 2;	
    	}
    	
    	for(int i = 3; i <= squareRoot; i = i + 2) {
    		while(numberToFactor % i == 0) {
    			factors.add(i);
    			numberToFactor /= i;
    		}
    	}
    	
    	if(numberToFactor != 1) {
    		factors.add(numberToFactor);
    	}
    	
    	return factors;
    }

}
