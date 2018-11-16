/**
 * Statistics.java
 * 
 * This class provides statistical functions to 
 * compute values associated with a data set. 
 * 
 */

package scientific;

import java.util.*;

public class Statistics {

	private static void checkInputHasElements(double[] inputArray) {
		if(inputArray.length == 0) {
			throw new IllegalArgumentException("The array of values must contain at least one element");
		}
	}

	public static double mean(double[] valuesToCalculateMeanOf){
		checkInputHasElements(valuesToCalculateMeanOf);
		double total = Arrays.stream(valuesToCalculateMeanOf).sum();
		return total / valuesToCalculateMeanOf.length;
	}
	
	public static double median(double[] valuesToCalculateMedianOf) {
		checkInputHasElements(valuesToCalculateMedianOf);
		Arrays.sort(valuesToCalculateMedianOf);
		if(valuesToCalculateMedianOf.length%2==1){
			return valuesToCalculateMedianOf[valuesToCalculateMedianOf.length/2];
		} else {
			double valueBelowMidpoint =  valuesToCalculateMedianOf[(valuesToCalculateMedianOf.length/2)-1];
			double valueAboveMidpoint = valuesToCalculateMedianOf[(valuesToCalculateMedianOf.length/2)];
			return  (valueBelowMidpoint+valueAboveMidpoint)/2;
		}
	}
	
	/**
	 * Finds the modes of the data
	 * 
	 * @param valuesToCalculateModeOf	Array of doubles
	 * @return		a double array of the data points with the most occurrences
	 */
	public static double[] mode(double[] valuesToCalculateModeOf){
		checkInputHasElements(valuesToCalculateModeOf);
		ArrayList<Double> maximumValues = new ArrayList<>();
		int currentMaximumCount = 0;
		Map<Double,Integer>  valueToCountMap = new HashMap<>();
		for (double valueInArray : valuesToCalculateModeOf) {
			if(!valueToCountMap.containsKey(valueInArray)) {
				valueToCountMap.put(valueInArray,1);
				if(currentMaximumCount <= 1) {
					currentMaximumCount = 1;
					maximumValues.add(valueInArray);
				}
			} else {
				int currentNumberOfOccurrences = valueToCountMap.get(valueInArray)+1;
				if(currentMaximumCount < currentNumberOfOccurrences) {
					currentMaximumCount = currentNumberOfOccurrences;
					maximumValues.clear();
					maximumValues.add(valueInArray);
				} else if(currentNumberOfOccurrences == currentMaximumCount) {
					maximumValues.add(valueInArray);
				}
				valueToCountMap.replace(valueInArray,currentNumberOfOccurrences);
			}
		}

		double[] arrayOfMaximumOccurrences = new double[maximumValues.size()];
		int index = 0;
		for (Double modeValue : maximumValues) {
			arrayOfMaximumOccurrences[index] = modeValue;
			index++;
		}

		return arrayOfMaximumOccurrences;
	}

	public static double minimum(double[] valuesToCalculateMinimumOf) {
		checkInputHasElements(valuesToCalculateMinimumOf);
		Arrays.sort(valuesToCalculateMinimumOf);
		return valuesToCalculateMinimumOf[0];
	}

	public static double maximum(double[] valuesToCalculateMaximumOf) {
		checkInputHasElements(valuesToCalculateMaximumOf);
		Arrays.sort(valuesToCalculateMaximumOf);
		return valuesToCalculateMaximumOf[valuesToCalculateMaximumOf.length - 1];
	}

	public static double variance(double[] valuesToCalculateVarianceOf) {
		checkInputHasElements(valuesToCalculateVarianceOf);
		double mean = mean(valuesToCalculateVarianceOf);
		double sigmaDataPointsTakeMean = 0;

		for (double dataPoint : valuesToCalculateVarianceOf) {
			double valueOfDataPointTakeMean = dataPoint - mean;
			sigmaDataPointsTakeMean += Math.pow(valueOfDataPointTakeMean,2);
		}
		
		return sigmaDataPointsTakeMean / valuesToCalculateVarianceOf.length;
	}

	public static double standardDeviation(double[] valuesToCalculateStandardDeviationOf) {
		return Math.sqrt(variance(valuesToCalculateStandardDeviationOf));
	}

}
