/*
 * Provides a Rational number class and performs operations on rational numbers.
 *   
 */

package scientific;

public class Rational implements Comparable<Rational> {
	
	private static Rational zero = new Rational(0, 1);
	private static Rational one = new Rational(1, 1);
	
	private final int nu;   
    private final int de;   

    public Rational(int num, int den) {
    	if(den == 0){
    		try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	// move negative to the numerator
    	if(den < 0){
    		nu = num * -1;
    		de = den * -1;
    	}else{
    		nu = num;
    		de = den;
    	}
    }
    
    public Rational plus(Rational a){
    	return zero;
    }
    
    public Rational minus(Rational a){
    	return zero;
    }
    
    public Rational times(Rational a){
    	return zero;
    }
    
    public Rational divided(Rational a){
    	return zero;
    }
    
    private int gcd(int a, int b){
    	return 0;
    }
    
    private int lcm(int a, int b){
    	return 0;
    }
    
    public int numerator(){
    	return nu;
    }
    
    public int denominator(){
    	return de;
    }
    
    public Rational abs(Rational a){
    	return zero;
    }
    
    public Rational negative(Rational a){
    	return zero;
    }

    public Rational reciprical(Rational a){
    	return zero;
    }
    
    @Override
    public int compareTo(Rational a){
    	return 0;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + de;
		result = prime * result + nu;
		return result;
	}

	@Override
	public String toString() {
		return nu + "/" + de;
	}

    public double toDouble(){    	
    	return (double) nu / de;    
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		if (de != other.de)
			return false;
		if (nu != other.nu)
			return false;
		return true;
	}

	private Rational reduce(){
		return zero;
	}

}
