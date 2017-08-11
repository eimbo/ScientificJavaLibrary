package library;

/**
 * Complex.java
 * 
 * Provides a Complex number object and performs operations on complex 
 * numbers.
 * 
 */

import java.util.Objects;

public class Complex {
    private final double re;   
    private final double im;   

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return absolute value/magnitude
    public double abs() {
        return Math.hypot(re, im);
    }

    // return angle/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(im, re);
    }

    // return a new Complex object with value equal to (this + c)
    public Complex plus(Complex c) {
        Complex a = this;             // invoking object
        double real = a.re + c.re;
        double imag = a.im + c.im;
        return new Complex(real, imag);
    }

    // return a new Complex object with value equal to (this - c)
    public Complex minus(Complex c) {
        Complex a = this;
        double real = a.re - c.re;
        double imag = a.im - c.im;
        return new Complex(real, imag);
    }

    // return a new Complex object with value equal to (this * c)
    public Complex times(Complex c) {
        Complex a = this;
        double real = a.re * c.re - a.im * c.im;
        double imag = a.re * c.im + a.im * c.re;
        return new Complex(real, imag);
    }

    // return a new object with value equal to (this * alpha)
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // return a new Complex object with value equal to the conjugate of this
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // return a new Complex object with value equal to the reciprocal of this
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return this / c
    public Complex divides(Complex c) {
        Complex a = this;
        return a.times(c.reciprocal());
    }

    // return a new Complex object with value equal to the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object with value equal to the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object with value equal to the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object with value equal to the complex tangent of this
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