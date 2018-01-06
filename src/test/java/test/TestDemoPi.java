/**
 * Unit test for Pi.java
 */

package test;

import static org.junit.Assert.*;
import org.junit.Test;

import demo.Pi;

public class TestDemoPi {
 
	@Test
	public void test() {
		
		assertTrue(Math.abs(Pi.compute() - Math.PI) < 0.001);

	}

}
