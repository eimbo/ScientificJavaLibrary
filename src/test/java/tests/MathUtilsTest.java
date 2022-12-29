package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import boweblogic.scientific.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void lowestCommonMultipleCorrectForSameNumber() {
        int lowestCommonMultiple = MathUtils.lowestCommonMultiple(2,2);
        assertEquals(2,lowestCommonMultiple);
    }

    @Test
    public void lowestCommonMultipleCorrectForPositiveNumbers() {
        int lowestCommonMultiple = MathUtils.lowestCommonMultiple(2,4);
        assertEquals(4,lowestCommonMultiple);
    }

    @Test
    public void lowestCommonMultipleCorrectForNegativeNumbers() {
        int lowestCommonMultiple = MathUtils.lowestCommonMultiple(-2,-4);
        assertEquals(4,lowestCommonMultiple);
    }

    @Test
    public void lowestCommonMultipleCorrectFor0Value() {
        int lowestCommonMultiple = MathUtils.lowestCommonMultiple(0,4);
        assertEquals(0,lowestCommonMultiple);
    }

    @Test
    public void isPrimeCorrectFor0Value() {
        assertFalse(MathUtils.isPrime(0));
    }

    @Test
    public void isPrimeCorrectFor2() {
        assertTrue(MathUtils.isPrime(2));
    }

    @Test
    public void isPrimeCorrectFor13() {
        assertTrue(MathUtils.isPrime(13));
    }

    @Test
    public void isPrimeCorrectFor10() {
        assertFalse(MathUtils.isPrime(10));
    }

    @Test
    public void isPrimeCorrectForNegative() {
        assertFalse(MathUtils.isPrime(-3));
    }
    
    @Test
    public void uniqueFactorization() {
    	List<Integer> result = MathUtils.uniqueFactorization(184);
    	
    	List<Integer> source = new ArrayList<Integer>(result);
    	List<Integer> destination = new ArrayList<Integer>(result);
    	
    	result.add(-1);
    	result.remove(result.indexOf(23));
    	source.removeAll(result);
    	result.removeAll(destination);

    	assertTrue(result.size() == 1);
    	assertTrue(result.get(0) == -1);
    	assertTrue(source.size() == 1);
    	assertTrue(source.get(0) == 23);
    }
    
    @Test
    public void uniqueFactorizationOfNegative() {
    	List<Integer> result = MathUtils.uniqueFactorization(-184);
    	
    	List<Integer> source = new ArrayList<Integer>(result);
    	List<Integer> destination = new ArrayList<Integer>(result);
    	
    	result.add(-2);
    	result.remove(result.indexOf(23));
    	source.removeAll(result);
    	result.removeAll(destination);

    	assertTrue(result.size() == 1);
    	assertTrue(result.get(0) == -2);
    	assertTrue(source.size() == 1);
    	assertTrue(source.get(0) == 23);
    }

}
