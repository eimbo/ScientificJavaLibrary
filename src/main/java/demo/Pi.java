package demo;

import java.util.Random;

/**
 * Uses the unit circle to estimate the value of Pi. 
 * 
 * The area of the unit circle is equal to Pi. The process considers random points
 * generated in the square region |x| <=  1, |y| <= 1. The approximate ratio of points in the 
 * circle to total points in the square is PI/4. 
 * 
 * Resource: https://en.wikipedia.org/wiki/Approximations_of_%CF%80
 * 
 */

public class Pi {
	
	private static final double pi = compute();
	private static final double rangeMin = -1.0;
	private static final double rangeMax = 1.0;
	private static final int iter = 2000000;

	private static int pointsInCircle;

	public static void print(){
		System.out.println(pi);
	}
	
	public static double compute(){	
		
		Random random = new Random();
		double xValue;
		double yValue;
		
		for(int i=0; i < iter; i++){
			// generate random (x,y) pair
			xValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
			yValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

			// ask if the point is in the circle
			if(Math.hypot(xValue, yValue) <= 1.0){
				pointsInCircle++;
			}
		}

		// compute pi
		return (double) pointsInCircle  / iter * 4.0;
		
	}
	
	
}
