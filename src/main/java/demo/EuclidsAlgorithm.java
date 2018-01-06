package demo;

/**
 * EuclidsAlgorithm.java
 * 
 * Given p and q compute the GCD using Euclid's Algorithm.
 * 
 */

public class EuclidsAlgorithm {

    // recursive
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive
    public static int gcd_nonrecur(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }
}
