package org.vkedco.lp.simplex_support.ratio;

/**
 * Class that implements a ratio.
 * bugs to vladimir dot kulyukin at gmail dot com.
 */
public class Ratio {
	private long mN;
	private long mD;
	
	public static final Ratio ONE = new Ratio(1, 1);
	public static final Ratio ZERO = new Ratio(0, 1);
	
	public Ratio(long n, long d) {
		if ( d == 0 ) 
			throw new IllegalArgumentException("zero denominator");
		
		if ( (n > 0 && d > 0) || ( n < 0 && d < 0) ) {
			mN = n;
			mD = d;
		}
		else {
			mN = -1 * Math.abs(n);
			mD = Math.abs(d);
		}
	}
	
	public long getNum() {
		return mN;
	}
	
	public long getDenum() {
		return mD;
	}
	
	public void reduceToLowestTerms() {
		if ( mN == 0 ) {
			mD = 1;
			return;
		}
		long num = Math.abs(mN);
		long den = Math.abs(mD);
		long gd = RatioArithmetic.gcd(num, den);
		//System.out.println("gd=" + gd);
		while ( gd != 1 ) {
			num /= gd;
			den /= gd;
			gd = RatioArithmetic.gcd(num, den);
		}
		
		if ( (mN < 0 && mD > 0 ) || (mN > 0 && mD < 0) ) {
			mN = -num;
			mD = den;
		}
		else {
			mN = num;
			mD = den;
		}
	}
	
	public String toString() {
		return mN + "/" + mD;
	}
	
	public Ratio flip() {
		if ( mN == 0 ) {
			return new Ratio(0, mD);
		}
		else if ( mN < 0 ) 
			return new Ratio(-mD, Math.abs(mN));
		else
			return new Ratio(mD, mN);
	}
}
