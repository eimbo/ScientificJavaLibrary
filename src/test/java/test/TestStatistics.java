/**
 * Unit test for Statistics.java.
 */

package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import scientific.Statistics;

public class TestStatistics extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestStatistics( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestStatistics.class );
    }

    /**
     * Rigorous Test B-)
     */
    public void testApp()
    {
    	testMode();
    }
    
    /**
     * Tests the two mode functions
     */
    public void testMode() {
    	// Every double used only once
    	double[] dataSet1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
    	double[] modesOfDataSet1 = Statistics.mode(dataSet1);
    	for(int index = 0; index < modesOfDataSet1.length; index++) {
    		assertTrue("Checking each index of modesOfDataSet1", dataSet1[index] == modesOfDataSet1[index]);
    	}
    	assertTrue("Checking modeCount for modesOfDataSet1", Statistics.modeCount(dataSet1) == 1);
    	
    	// Unsorted data with a single mode
    	double[] dataSet2 = {5.0, 9.0, 20.0, 1.0, 5.0, 3.0, 5.0};
    	double[] modesOfDataSet2 = Statistics.mode(dataSet2);
    	assertTrue("Checking length of modesOfDataSet2", modesOfDataSet2.length == 1);
    	assertTrue("Checking contents of modesOfDataSet2", modesOfDataSet2[0] == 5.0);
    	assertTrue("Checking modeCount of modesOfDataSet2", Statistics.modeCount(dataSet2) == 3);
    	
    	// Data set with two modes
    	double[] dataSet3 = {1.0, 2.0, 3.0, 1.0, 3.0, 7.0, 9.0};
    	double[] modesOfDataSet3 = Statistics.mode(dataSet3);
    	assertTrue("Checking length of modesOfDataSet3", modesOfDataSet3.length == 2);
    	assertTrue("Checking contents of modesOfDataSet3", modesOfDataSet3[0] == 1.0 && modesOfDataSet3[1] == 3.0);
    	assertTrue("Checking modeCount of modesOfDataSet3", Statistics.modeCount(dataSet3) == 2);
    }
}
