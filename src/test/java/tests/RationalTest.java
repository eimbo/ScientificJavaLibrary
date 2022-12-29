package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import boweblogic.scientific.algebra.Rational;


public class RationalTest {

    @Test
    public void correctlyGets2Over4() {
        Rational half = new Rational(2,4);
        assertEquals(2,half.getNumerator());
        assertEquals(4,half.getDenominator());
    }

    @Test
    public void correctlyAdds2Rationals() {
        Rational half = new Rational(2,4);
        Rational threeQuarters = new Rational(3,4);
        Rational oneAndAQuarter = half.add(threeQuarters);
        assertEquals(20,oneAndAQuarter.getNumerator());
        assertEquals(16,oneAndAQuarter.getDenominator());
    }

    @Test
    public void correctlyAddsIntegerValue() {
    	Rational threeQuarters = new Rational(3, 4);
    	Rational sevenFourths = threeQuarters.add(1);
    	assertEquals(7, sevenFourths.getNumerator());
    	assertEquals(4, sevenFourths.getDenominator());
    }
    
    @Test
    public void correctlyAddsNegativeRational() {
        Rational half = new Rational(2,4);
        Rational minusQuarter = new Rational(-1,4);
        Rational oneQuarter = half.add(minusQuarter);
        assertEquals(4,oneQuarter.getNumerator());
        assertEquals(16,oneQuarter.getDenominator());
    }

    @Test
    public void correctlySubtracts2Rationals() {
        Rational half = new Rational(2,4);
        Rational quarter = new Rational(1,4);
        Rational oneQuarter = half.subtract(quarter);
        assertEquals(4,oneQuarter.getNumerator());
        assertEquals(16,oneQuarter.getDenominator());
    }

    @Test
    public void correctlySubtractIntegerValue() {
    	Rational sevenFourths = new Rational(7, 4);
    	Rational threeQuarters = sevenFourths.subtract(1);
    	assertEquals(12, threeQuarters.getNumerator());
    	assertEquals(16, threeQuarters.getDenominator());
    	
    	Rational minusQuarter = sevenFourths.subtract(2);
    	assertEquals(-4, minusQuarter.getNumerator());
    	assertEquals(16, minusQuarter.getDenominator());
    }
    
    @Test
    public void correctlySubtracts2RationalsForNegativeAnswer() {
        Rational half = new Rational(2,4);
        Rational threeQuarters = new Rational(3,4);
        Rational minusOneQuarter = half.subtract(threeQuarters);
        assertEquals(-4,minusOneQuarter.getNumerator());
        assertEquals(16,minusOneQuarter.getDenominator());
    }

    @Test
    public void correctlyMultiplies2Rationals() {
        Rational half = new Rational(2,4);
        Rational oneQuarter = half.multiply(half);
        assertEquals(4,oneQuarter.getNumerator());
        assertEquals(16,oneQuarter.getDenominator());
    }

    @Test
    public void correctlyMultipliesNegativeRational() {
        Rational half = new Rational(2,4);
        Rational minusHalf = new Rational(-2,4);
        Rational minusQuarter = half.multiply(minusHalf);
        assertEquals(-4,minusQuarter.getNumerator());
        assertEquals(16,minusQuarter.getDenominator());
    }

    @Test
    public void correctlyDividesSameRationals() {
        Rational half = new Rational(2,4);
        Rational one = half.divide(half);
        assertEquals(one.getNumerator(),one.getDenominator());
    }

    @Test
    public void correctlyDivides2Rationals() {
        Rational half = new Rational(2,4);
        Rational quarter = new Rational(1,4);
        Rational two = half.divide(quarter);
        assertEquals(8,two.getNumerator());
        assertEquals(4,two.getDenominator());
    }

    @Test
    public void correctlyGetsDoubleForRational() {
        Rational half = new Rational(2,4);
        assertEquals(0.5,half.toDouble(),0);
    }

    @Test
    public void correctlyGetsDoubleForNegativeRational() {
        Rational minusHalf = new Rational(-2,4);
        assertEquals(-0.5,minusHalf.toDouble(),0);
    }

    @Test
    public void correctlyGetsAbsoluteForRational() {
        Rational half = new Rational(2,4);
        assertEquals(0.5,half.abs(),0);
    }

    @Test
    public void correctlyGetsAbsoluteForNegativeRational() {
        Rational minusHalf = new Rational(-2,4);
        assertEquals(0.5,minusHalf.abs(),0);
    }

    @Test
    public void correctlyGetsNegativeOfRational() {
        Rational half = new Rational(2,4);
        assertEquals(-0.5,half.negative().toDouble(),0);
    }

    @Test
    public void correctlyGetsReciprocalOfRational() {
        Rational half = new Rational(2,4);
        assertEquals(2,half.reciprocal().toDouble(),0);
    }

    @Test
    public void correctlyGetsStringOfReciprocal() {
        Rational half = new Rational(2,4);
        assertEquals("2/4",half.toString());
    }

    @Test
    public void fromThrowsWhenStringIsText() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("hello world");
		});
    }

    @Test
    public void fromThrowsWhenMissingNumerator() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("/6");
		});
    }

    @Test
    public void fromThrowsWhenNumeratorLetter() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("a/6");
		});
    }

    @Test
    public void fromThrowsWhenMissingSlash() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("65");
		});
    }

    @Test
    public void fromThrowsWhenMissingDenominator() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("6/");
		});
    }

    @Test
    public void fromThrowsWhenDenominatorLetter() {
		assertThrows(IllegalArgumentException.class, () -> {
			Rational.from("6/a");
		});
    }

    @Test
    public void fromReturnsRationalWhenValidStringPassed() {
        assertEquals(new Rational(2,3),Rational.from("2/3"));
    }

    @Test
    public void simplifyReturnsCorrectValueForHalf() {
        Rational unsimplifiedHalf = new Rational(2,4);
        Rational simplifiedRational = unsimplifiedHalf.simplify();
        assertEquals(simplifiedRational.getNumerator(),1);
        assertEquals(simplifiedRational.getDenominator(),2);
    }

}
