/*
 * Utitility functions on ratios.
 * Bugs to vladimir dot kulyukin at gmail dot com.
 */
package org.vkedco.lp.simplex_support.ratio;

public class RatioArithmetic {
	
	public static final Ratio ZERO = new Ratio(0, 1);

	public static long gcd(long x, long y) {
		// System.out.println("gcd of " + x + " " + y);
		if (x == 0 && y == 0)
			throw new IllegalArgumentException("gcd(0, 0)");
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		long curr_x = y;
		long curr_y = x % y;
		long temp;
		// System.out.println("curr_x=" + curr_x + " curr_y=" + curr_y);
		while (curr_y != 0) {
			// System.out.println("curr_x=" + curr_x + " curr_y=" + curr_y);
			temp = curr_x;
			curr_x = curr_y;
			curr_y = temp % curr_y;
		}
		return curr_x;
	}

	public static long lcm(long x, long y) {
		return (x * y) / gcd(x, y);
	}

	public static Ratio abs(Ratio r) {
		return new Ratio(Math.abs(r.getNum()), r.getDenum());
	}

	public static Ratio add(Ratio r1, Ratio r2) {
		r1.reduceToLowestTerms();
		r2.reduceToLowestTerms();
		long n1 = r1.getNum();
		long n2 = r2.getNum();
		long d1 = r1.getDenum();
		long d2 = r2.getDenum();
		long lm = lcm(d1, d2);
		Ratio sum = new Ratio(((n1 * lm / d1) + (n2 * lm / d2)), lm);
		sum.reduceToLowestTerms();
		return sum;
	}

	public static Ratio mult(Ratio r1, Ratio r2) {
		r1.reduceToLowestTerms();
		r2.reduceToLowestTerms();
		Ratio sum = new Ratio(r1.getNum() * r2.getNum(), r1.getDenum()
				* r2.getDenum());
		sum.reduceToLowestTerms();
		return sum;
	}

	public static Ratio div(Ratio r1, Ratio r2) {
		if (r2.getNum() == 0)
			throw new ArithmeticException("/ by zero");
		return mult(r1, r2.flip());
	}

	public static void main(String[] args) {
		Ratio r1 = new Ratio(-1, 2);
		Ratio r2 = new Ratio(-24, 16);
		System.out.println(mult(new Ratio(-1, 1), new Ratio(4, 1)));
	}

	// -1 if r1 < r2
	// 0 if r1 == r2
	// 1 if r1 > r2
	public static int compare(Ratio r1, Ratio r2) {
		if (r1.getNum() < 0 && r2.getNum() >= 0) {
				return -1;
		}
		else if (r1.getNum() > 0 && r2.getNum() <= 0)
			return 1;
		else if (r1.getNum() == 0 && r2.getNum() == 0)
			return 0;
		else if (r1.getNum() == 0 && r2.getNum() > 0 )
			return -1;
		else {
			Ratio abs_r1 = abs(r1);
			Ratio abs_r2 = abs(r2);
			abs_r1.reduceToLowestTerms();
			abs_r2.reduceToLowestTerms();
			long n1 = abs_r1.getNum();
			long n2 = abs_r2.getNum();
			long d1 = abs_r1.getDenum();
			long d2 = abs_r2.getDenum();
			long lm = lcm(d1, d2);
			long nn1 = n1 * lm / d1;
			long nn2 = n2 * lm / d2;

			if ( r1.getNum() < 0 && r2.getNum() < 0 ) {
				if ( nn1 < nn2 )
					return 1;
				else if ( nn1 > nn2 )
					return -1;
				else
					return 0;
			}
			else if ( r1.getNum() > 0 && r2.getNum() > 0 ) {
				if ( nn1 < nn2 )
					return -1;
				else if ( nn1 > nn2 )
					return 1;
				else
					return 0;
			}
			else
				return 0;
		}
	}
}
