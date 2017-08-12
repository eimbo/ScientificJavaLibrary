/**
 * Statistics.java
 * 
 * This class provides statistical functions to 
 * compute values associated with a data set. 
 * 
 */

package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	
	/**
	 * Finds the modes of the data
	 * 
	 * @param data	Array of doubles
	 * @return		a double array of the data points with the most occurrences
	 */
	public static double[] mode(double[] data){
		Double[] modesDoubles = modeHelper(data)[0];
		double[] modes = new double[modesDoubles.length];
		
		// Changes Double to double
		for( int index = 0; index < modesDoubles.length; index++ ) {
			modes[index] = modesDoubles[index].doubleValue();
		}
		
		return modes;
	}
	
	/**
	 * Finds the number of occurrences of the mode(s) of the data
	 * 
	 * @param data	Array of doubles
	 * @return		an int representing the number of occurrences of the mode
	 */
	public static int modeCount(double[] data) {
		return modeHelper(data)[1][0].intValue();
	}
	
	/**
	 * Used by the mode function's to avoid unneeded repetition of code
	 * 
	 * @param data	Array of doubles
	 * @return		an array holding the array of modes in the first index and an array holding the number of occurrences of the mode(s)
	 */
	private static Double[][] modeHelper(double[] data) {
		ArrayList<Double> modeValues = new ArrayList<Double>();
		Double maxModeCount = new Double(0);
		
		// The key of this map is a value from data
		// The value of this map is the number of occurrences of the data point
		Map<Double, Double> valueOccurrences = new HashMap<Double, Double>();
		
		for(int index = 0; index < data.length; index++) {
			Double dataValue = new Double(data[index]);
			
			// Update dataValue's number of occurrences
			if(valueOccurrences.containsKey(dataValue)) {
				valueOccurrences.put(dataValue, valueOccurrences.get(dataValue) + 1);
			} else {
				valueOccurrences.put(dataValue, new Double(1));
			}
			
			// Update modeValues and maxModeCount accordingly
			Double numOccurrences = valueOccurrences.get(dataValue);
			if(numOccurrences.doubleValue() > maxModeCount.doubleValue()) {
				modeValues = new ArrayList<Double>();
				modeValues.add(dataValue);
				maxModeCount = numOccurrences;
			} else if(numOccurrences.doubleValue() == maxModeCount.doubleValue()) {
				modeValues.add(dataValue);
			}
		}
		
		// Create an array to return that holds the modes and the mode count
		// First index is the array of modes, second is an array of the mode count
		Double[] modeValuesArray = new Double[modeValues.size()];
		modeValuesArray = modeValues.toArray(modeValuesArray);
		
		Double[][] results = {modeValuesArray, {maxModeCount}};
		return results;
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
