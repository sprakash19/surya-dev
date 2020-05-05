package com.sample1;
/**
 * 
 * @author srduvvur
 * You are climbing a stair case. It takes n steps to reach to the top.

 *Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 *Note: Given n will be a positive integer.
 *
 */

public class ClimbingStairs {
	
	public static void main(String[] args) {
		
		int n =8;
		
		ClimbingStairs obj = new ClimbingStairs();
		System.out.println(obj.climb(n));
	}
	
	private int climb(int n) {
		if(n == 1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		return climb(n-1)+climb(n-2);
	}

}
