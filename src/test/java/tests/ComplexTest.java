package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import scientific.Complex;



public class ComplexTest {

    @Test
    public void correctlyAssignsReAndImParts() {
        Complex value = new Complex(2,4);
        assertEquals(2,value.real(), 0);
        assertEquals(4,value.imaginary(), 0);
    }

    @Test
    public void correctyShowsValueWithNegativeImAsAString() {
        Complex value = new Complex(2,-4);
        assertEquals("2.0 - 4.0i", value.toString());
    }

    @Test
    public void correctyShowsValueWithPositiveImAsAString() {
        Complex value = new Complex(2,4);
        assertEquals("2.0 + 4.0i", value.toString());
    }

    @Test
    public void correctySumsValues() {
        Complex value1 = new Complex(2,4);
        Complex value2 = new Complex(4,6);
        assertEquals(new Complex(6,10), value1.plus(value2));
    }

    @Test
    public void correctySubtractsValues() {
        Complex value1 = new Complex(2,4);
        Complex value2 = new Complex(4,6);
        assertEquals(new Complex(-2,-2), value1.minus(value2));
    }

    @Test
    public void correctyTimesValues() {
        Complex value1 = new Complex(2,4);
        Complex value2 = new Complex(4,6);
        assertEquals(new Complex(-16,28), value1.times(value2));
    }

    @Test
    public void correctyScalesValue() {
        Complex value = new Complex(2,4);
        assertEquals(new Complex(4,8), value.scale(2));
    }

    @Test
    public void correctConjugatesValue() {
        Complex value = new Complex(2,4);
        assertEquals(new Complex(2,-4), value.conjugate());
    }

    @Test
    public void correctReciprocalsValue() {
        Complex value = new Complex(2,4);
        assertEquals(new Complex(0.1,-0.2), value.reciprocal());
    }

    @Test
    public void correctDividesValues() {
        Complex value1 = new Complex(2,4);
        Complex value2 = new Complex(4,6);
        assertEquals(0.6154, value1.divides(value2).real(), 0.1);
        assertEquals(0.0769, value1.divides(value2).imaginary(), 0.1);
    }
}
