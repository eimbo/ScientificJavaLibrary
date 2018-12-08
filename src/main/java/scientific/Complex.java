package scientific;

import java.util.Objects;

/**
 * Provides a Complex number class and performs operations on complex numbers.
 */
public class Complex {
	
    private final double re;   
    private final double im;   

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im <  0) {
        	return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }

    public double abs() {
        return Math.hypot(re, im);
    }

    // return angle/argument normalized to be between -pi and pi
    public double argument() {
        return Math.atan2(im, re);
    }

    public Complex plus(Complex c) {
        Complex a = this;             // invoking object
        double real = a.re + c.re;
        double imag = a.im + c.im;
        return new Complex(real, imag);
    }

    public Complex minus(Complex c) {
        Complex a = this;
        double real = a.re - c.re;
        double imag = a.im - c.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex c) {
        Complex a = this;
        double real = a.re * c.re - a.im * c.im;
        double imag = a.re * c.im + a.im * c.re;
        return new Complex(real, imag);
    }

    public Complex scale(double scale) {
        return new Complex(scale * re, scale * im);
    }

    public Complex conjugate() {
        return new Complex(re, -im);
    }

    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    public double real() { return re; }
    
    public double imaginary() { return im; }

    public Complex divides(Complex c) {
        Complex a = this;
        return a.times(c.reciprocal());
    }

    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    public Complex tan() {
        return sin().divides(cos());
    }

    // a static version of plus
    public static Complex plus(Complex c1, Complex c2) {
        double real = c1.re + c2.re;
        double imag = c1.im + c2.im;
        Complex sum = new Complex(real, imag);
        return sum;
    }

    public boolean equals(Object c) {
        if (c == null) return false;
        if (this.getClass() != c.getClass()) return false;
        Complex that = (Complex) c;
        return (this.re == that.re) && (this.im == that.im);
    }

    public int hashCode() {
        return Objects.hash(re, im);
    }


}