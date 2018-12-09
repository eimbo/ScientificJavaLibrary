package tests;
import org.junit.Test;
import scientific.Statistics;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StatisticsTest {

    @Test
    public void meanCorrectForPositiveNumbers() {
        double[] numbersToCalculateMeanOf = {1.5,2.3,0.9,12.3,0};
        double meanOfDataSet = Statistics.mean(numbersToCalculateMeanOf);
        assertEquals(3.4,meanOfDataSet,0);
    }

    @Test
    public void meanCorrectForNegativeNumbers() {
        double[] numbersToCalculateMeanOf = {-1.5,-2.3,-0.9,-12.3,0};
        double meanOfDataSet = Statistics.mean(numbersToCalculateMeanOf);
        assertEquals(-3.4,meanOfDataSet,0);
    }

    @Test
    public void meanCorrectForCombinationOfNumbers() {
        double[] numbersToCalculateMeanOf = {3,-1.4,-14.5,5,4.1,0,19.7};
        double meanOfDataSet = Statistics.mean(numbersToCalculateMeanOf);
        assertEquals(2.2714285714285714,meanOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void meanThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] emptyDoubleArray = {};
        Statistics.mean(emptyDoubleArray);
    }

    @Test
    public void medianCorrectForOneNumber() {
        double[] numbersToCalculateMedianOf = {2};
        double medianOfDataSet = Statistics.median(numbersToCalculateMedianOf);
        assertEquals(2,medianOfDataSet,0);
    }

    @Test
    public void medianCorrectForPositiveNumbers() {
        double[] numbersToCalculateMedianOf = {4,9,1,3,0,6};
        double medianOfDataSet = Statistics.median(numbersToCalculateMedianOf);
        assertEquals(3.5,medianOfDataSet,0);
    }

    @Test
    public void medianCorrectForNegativeNumbers() {
        double[] numbersToCalculateMedianOf = {-4,-9,-1,-3,0,-6};
        double medianOfDataSet = Statistics.median(numbersToCalculateMedianOf);
        assertEquals(-3.5,medianOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void medianThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToCalculateMedianOf = {};
        Statistics.median(numbersToCalculateMedianOf);
    }

    @Test
    public void medianCorrectForCombinationOfNumbers() {
        double[] numbersToCalculateMeanOf = {3,-1.4,-14.5,5,4.1,0,19.7};
        double medianOfDataSet = Statistics.median(numbersToCalculateMeanOf);
        assertEquals(3.0,medianOfDataSet,0);
    }

    @Test
    public void modeCorrectForOneNumber() {
        double[] numbersToFindModeOf = {3};
        double[] modeOfDataSet = Statistics.mode(numbersToFindModeOf);
        assertEquals(1,modeOfDataSet.length);
        assertEquals(3,modeOfDataSet[0],0);
    }

    @Test
    public void modeCorrectForSingleModeData() {
        double[] numbersToFindModeOf = {3,4.3,0.7,9,4.3,0,-18,103.45};
        double[] modeOfDataSet = Statistics.mode(numbersToFindModeOf);
        assertEquals(1,modeOfDataSet.length);
        assertEquals(4.3,modeOfDataSet[0],0);
    }

    @Test
    public void modeCorrectForDualModeData() {
        double[] numbersToFindModeOf = {3,4.3,0.7,9,4.3,0,-18,103.45,-18};
        double[] modeOfDataSet = Statistics.mode(numbersToFindModeOf);
        double[] actualModeOfDataSet = {4.3,-18};
        assertArrayEquals(actualModeOfDataSet,modeOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void modeThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToFindModeOf = {};
        Statistics.mode(numbersToFindModeOf);
    }

    @Test
    public void minimumCorrectForOneValue() {
        double[] numbersToFindMinimumOf = {3};
        double minimumOfDataSet = Statistics.minimum(numbersToFindMinimumOf);
        assertEquals(3,minimumOfDataSet,0);
    }

    @Test
    public void minimumCorrectForPositiveNumbers() {
        double[] numbersToFindMinimumOf = {3,3,9.5,4,6.027,7.4,9,2,2,10};
        double minimumOfDataSet = Statistics.minimum(numbersToFindMinimumOf);
        assertEquals(2,minimumOfDataSet,0);
    }

    @Test
    public void minimumCorrectForNegativeNumbers() {
        double[] numbersToFindMinimumOf = {-3,-3,-9.5,-4,-6.027,-7.4,-9,-2,-2,-10};
        double minimumOfDataSet = Statistics.minimum(numbersToFindMinimumOf);
        assertEquals(-10,minimumOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minimumThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToFindMinimumOf = {};
        Statistics.minimum(numbersToFindMinimumOf);
    }

    @Test
    public void maximumCorrectForOneValue() {
        double[] numbersToFindMinimumOf = {3};
        double minimumOfDataSet = Statistics.maximum(numbersToFindMinimumOf);
        assertEquals(3,minimumOfDataSet,0);
    }

    @Test
    public void maximumCorrectForPositiveNumbers() {
        double[] numbersToFindMinimumOf = {3,3,9.5,4,6.027,7.4,9,2,2,10};
        double minimumOfDataSet = Statistics.maximum(numbersToFindMinimumOf);
        assertEquals(10,minimumOfDataSet,0);
    }

    @Test
    public void maximumCorrectForNegativeNumbers() {
        double[] numbersToFindMinimumOf = {-3,-3,-9.5,-4,-6.027,-7.4,-9,-2,-2,-10};
        double minimumOfDataSet = Statistics.maximum(numbersToFindMinimumOf);
        assertEquals(-2,minimumOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maximumThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToFindMinimumOf = {};
        Statistics.maximum(numbersToFindMinimumOf);
    }

    @Test
    public void varianceCorrectForOneValue() {
        double[] numbersToFindVarianceOf = {3};
        double varianceOfDataSet = Statistics.variance(numbersToFindVarianceOf);
        assertEquals(0,varianceOfDataSet,0);
    }

    @Test
    public void varianceCorrect() {
        double[] numbersToFindVarianceOf = {4,3.4,0,9,8,9.7,1,9,9.3,0.3,18};
        double varianceOfDataSet = Statistics.variance(numbersToFindVarianceOf);
        assertEquals(26.534214876033058,varianceOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void varianceThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToFindVarianceOf = {};
        Statistics.variance(numbersToFindVarianceOf);
    }

    @Test
    public void standardDeviationCorrectForOneValue() {
        double[] numbersToFindStandardDeviationOf = {3};
        double standardDeviationOfDataSet = Statistics.standardDeviation(numbersToFindStandardDeviationOf);
        assertEquals(0,standardDeviationOfDataSet,0);
    }

    @Test
    public void standardDeviation() {
        double[] numbersToFindStandardDeviationOf = {4,3.4,0,9,8,9.7,1,9,9.3,0.3,18};
        double varianceOfDataSet = Statistics.standardDeviation(numbersToFindStandardDeviationOf);
        assertEquals(5.151137241040376,varianceOfDataSet,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void standardDeviationThrowsIllegalArgumentExceptionOnEmptyArray() {
        double[] numbersToFindStandardDeviationOf = {};
        Statistics.standardDeviation(numbersToFindStandardDeviationOf);
    }

}
