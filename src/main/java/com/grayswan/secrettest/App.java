package com.grayswan.secrettest;

/**
 * Author: will
 */
public class App {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: secrettest Max_Prime_Value");
			return;
		}
		int maxPrime = -1;
		try {
			maxPrime = Integer.parseInt(args[0]);
		} catch (Exception ex) {
			System.err.println("Invalid Max_Prime_Value: " + args[0] + ", " + ex.getMessage());
			return;
		}
		if (maxPrime < 1) {
			System.err.println("Invalid Max_Prime_Value: " + args[0] + ", must be greated than 0.");
			return;
		}
		
		if (testSecret(maxPrime, new Secret() {
				public int secret(int value) {
					return value;
				}
			}
		)) {
			System.out.println("Secret is Additive");
		} else {
			System.out.println("Secret is not Additive");
		}
	}

	public static boolean testSecret(int maxPrime, Secret secret) {
		IntList primes = new IntList();
		generatePrimes(primes, maxPrime);
		for (int lowPrimeIndex = 0; lowPrimeIndex <= primes.getSize()-1; lowPrimeIndex++) {
			for (int highPrimeIndex = lowPrimeIndex+1; highPrimeIndex <= primes.getSize(); highPrimeIndex++) {
				int lowPrime = primes.get(lowPrimeIndex);
				int highPrime = primes.get(highPrimeIndex);
				if (secret.secret(lowPrime + highPrime) != secret.secret(lowPrime) + secret.secret(highPrime)) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void generatePrimes(IntList primes, int maxPrime) {
		primes.add(1);
		primes.add(2);
		for (int i = 3; i < maxPrime; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}
	
	static boolean isPrime(long n) {
		// borrowed from http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
		//check if n is a multiple of 2
		if (n % 2 == 0) {
			return false;
		}
		//if not, then just check the odds
		for (int i = 3; i*i<=n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
