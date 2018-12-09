
package scientific;

/**
 * Generates pseudorandom numbers from different distributions 
 * (bernoulli, uniform, gaussian, discrete, and exponential). Relies on 
 * randomness of nextDouble() method in java.util.Random to generate 
 * pseudorandom numbers in [0, 1).
 * 
 */
public class RandomNumbers {
	
	// TODO implement
	// bernoulli
	// gaussian
	// exponential
	
	
	/**
	 * Value from Uniform distribution (continuous)
	 * @param min		
	 * @param max		
	 * @return random
	 */
	public static double getUniform(int min, int max){
		return min + Math.random() * (max-min) + 1;
	}
	

	/**
	 * Value from Uniform distribution (discrete
	 * @param n		number of outcomes		
	 * @return random
	 */
	public static double getUniform_discrete(int n){
		return (int) Math.random() * n + 1;	
	}
	
	/**
	 * Value from a Binomial distribution.
	 * @param n		number of experiements
	 * @param p 	probability of a single success [0,1)
	 * @return number of sucesses in n runs
	 */
	public static int getBinomial(int n, double p){
		int x = 0;
		for(int i = 0; i < n; i++) {
		  if(Math.random() < p)
		    x++;
		}
		return x;
	}
	
	
	/**
	 * Value from the Poisson distribution. 
	 * https://en.wikipedia.org/wiki/Poisson_distribution#Generating_Poisson-distributed_random_variables
	 * @param lambda	unit rate of occurances
	 * @return	int
	 */
	public static int getPoisson(double lambda){
		double L = Math.exp(-lambda);
		double p = 1.0;
		int k = 0;

		do {
		  k++;
		  p *= Math.random();
		} while (p > L);

		return k - 1;
	}
}
