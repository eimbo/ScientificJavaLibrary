package library;

/**
 * This program uses the unit circle to estimate the value of Pi. 
 * 
 * The area of the unit circle is equal to Pi. The process considers points
 * in the region |x| <=  1, |y| <= 1. The approximate number of points in the 
 * circle is PI/4. Resource: https://en.wikipedia.org/wiki/Approximations_of_%CF%80
 * 
 */

public class Pi {
	private static final double PI = compute();
	
	static{
		compute();
	}

	public static double compute(){
		// TODO implement		
		return 3.14;
	}
	
	
}
