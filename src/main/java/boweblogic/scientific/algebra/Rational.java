package boweblogic.scientific.algebra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import boweblogic.scientific.utils.MathUtils;

/** 
 * Provides a Rational number class and performs operations on rational numbers. 
 */
public class Rational implements Comparable<Rational> {

	private static Pattern compiledRegexRationalFrom = Pattern.compile("[0-9]+/[0-9]+");

	private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
    	if(denominator == 0){
    		throw new IllegalArgumentException("getDenominator must not be 0");
    	}
    	// move negative to the getNumerator
    	if(denominator < 0){
    		this.numerator = numerator * -1;
    		this.denominator = denominator * -1;
    	}else{
    		this.numerator = numerator;
    		this.denominator = denominator;
    	}
    }

    public static Rational from(String stringToGenerateRationalOn) {
		Matcher regexMatcher = compiledRegexRationalFrom.matcher(stringToGenerateRationalOn);
		if(!regexMatcher.matches()) {
			throw new IllegalArgumentException("Invalid format for Rational.from, must be in format a/b");
		}
    	String[] splitOnSlash = stringToGenerateRationalOn.split("/");
		int numerator = Integer.parseInt(splitOnSlash[0]);
    	int denominator = Integer.parseInt(splitOnSlash[1]);
    	return new Rational(numerator,denominator);
	}
    
    public Rational add(Rational rationalToAdd){
    	int newDenominator = denominator*rationalToAdd.denominator;
    	int currentNumeratorTimesAdditionalCurrentDivisor = numerator*rationalToAdd.denominator;
    	int additionalNumeratorTimesCurrentDivisor = rationalToAdd.numerator*denominator;
    	int sumOfNewNumerators = currentNumeratorTimesAdditionalCurrentDivisor+additionalNumeratorTimesCurrentDivisor;
    	return new Rational(sumOfNewNumerators,newDenominator);
    }
    
    public Rational add(int integerToAdd) {
    	return new Rational(numerator + (integerToAdd * denominator), denominator);
    }

	public int getNumerator(){
		return numerator;
	}

	public int getDenominator(){
		return denominator;
	}
    
    public Rational subtract(Rational valueToSubtract){
    	return this.add(valueToSubtract.negative());
    }
    
    public Rational subtract(int integerToSubtract) {
    	return this.add(new Rational (integerToSubtract * denominator, denominator).negative());
    }
    
    public Rational multiply(Rational rationalToMultiply){
    	return new Rational(numerator*rationalToMultiply.numerator,
				denominator*rationalToMultiply.denominator);
    }
    
    public Rational divide(Rational rationalToDivideBy){
    	return multiply(rationalToDivideBy.reciprocal());
    }

	public Rational negative(){
		return new Rational(-numerator,denominator);
	}

	public Rational reciprocal(){
		return new Rational(denominator,numerator);
	}

	public Rational simplify() {
    	int greatestCommonDivisor = MathUtils.greatestCommonDivisor(numerator,denominator);
    	return new Rational(numerator/greatestCommonDivisor,denominator/greatestCommonDivisor);
	}

    public double abs(){
    	return Math.abs(toDouble());
    }
    
    @Override
    public int compareTo(Rational rationalToCompareTo){
    	if(toDouble() == rationalToCompareTo.toDouble()) {
    		return 0;
		} else if(toDouble() > rationalToCompareTo.toDouble()) {
    		return 1;
		}
		return -1;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime + denominator;
		result = prime * result + numerator;
		return result;
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

    public double toDouble(){    	
    	return (double)numerator / (double)denominator;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		return denominator == other.denominator && numerator == other.numerator;
	}

}
