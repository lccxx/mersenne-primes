package org.opnfre.math;

import java.math.BigInteger;
import java.util.Date;

public class PrimalityTest {
	
	public static void findNextMersennePrime (int exponent) {
		int certainty = 2147483647;
		BigInteger primeExponent = new BigInteger(new Integer(exponent).toString());
		if (primeExponent.isProbablePrime(certainty)) {
			System.out.print("2^" + exponent + "-1\t" + new Date() + "\t");
			if (lucasLehmerPrimalityTest(exponent)) {
				System.out.println("is primality	" + new Date());
			} else {
				System.out.println();
			}
		}
		findNextMersennePrime (new Integer(primeExponent.nextProbablePrime().toString()));
	}
	
	/**
	 * Lucas–Lehmer primality test
	 * 		http://en.wikipedia.org/wiki/Lucas-Lehmer_test_for_Mersenne_numbers
	 * @param p - prime
	 * @return true -> prime， false -> composite
	 */
	public static boolean lucasLehmerPrimalityTest (int p) {
		BigInteger s = new BigInteger("4");
		BigInteger m = new BigInteger("2").shiftLeft(p-1).subtract(new BigInteger("1"));
		for (int i=0; i<p-2; i++)
			s = s.multiply(s).subtract(new BigInteger("2")).mod(m);
		if (s.compareTo(new BigInteger("0"))==0) return true;
		return false;
	}
	
	public static void main (String[] args) {
		int exponent = 43112609;
		findNextMersennePrime (exponent);
	}
}