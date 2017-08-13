package test;

import static org.junit.Assert.*;
import org.junit.Test;

import library.Pi;

public class TestPi {
 
	@Test
	public void test() {
		
		assertTrue(Math.abs(Pi.compute() - Math.PI) < 0.001);

	}

}
