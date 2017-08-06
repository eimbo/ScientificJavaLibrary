/**
 * Statistics.java
 * 
 * This class provides statistical functions to 
 * compute values associated with a data set. 
 * 
 */

package library;

import java.util.Arrays;

public class Statistics {

	public static double mean(double[] data){
		double total = 0;
		for(double d : data){
			total = total + d;
		}

		return total/data.length;
	}
	
	public static double median(double[] data) {
		double median = 0;
		Arrays.sort(data);
		if(data.length%2==1){
			median = data[data.length/2];
		}
		if(data.length%2==0){
			double i =  data[(data.length/2) -1];
			double j = data[(data.length/2) +1];
			median = (i+j)/2;
		}
		return median;
	}
	
	public static double mode(double[] data){
		// most occurrences or no mode if no number appears more than another
		return 0;
	}
	
	public static double minimun(double[] data) {
		Arrays.sort(data);
		return data[0];
	}

	public static double maximum(double[] data) {
		Arrays.sort(data);
		return data[data.length - 1];
	}

	public static double sample_variance(double[] data) {
		double mean = mean(data); 
		double sum = 0;
		
		for(int i = 0; i < data.length; i++){
			double diff = data[i]-mean;
			sum  = sum + (diff * diff);
		}
		
		return sum / data.length;
	}

	public static double sample_std_deviation(double[] data) {
		return Math.sqrt(sample_variance(data));
	}

}
