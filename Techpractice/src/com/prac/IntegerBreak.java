package com.prac;

public class IntegerBreak {

	public static int integerBreak(int n) {
		
		int max = 0;
		int result = helper(n+1, 1, max, 1);
		
		System.out.println(result);
		return n;
		
		
    }
	
	public static int helper(int n, int sum, int max, int multi) {
		if(sum > n) {
			return 0;
		}
		
		if(sum == n) {
			return multi;
		}
		for(int i = 1; i < n; i++) {
		
			int result = helper(n, sum+i, max, multi*i);
			
			
			max = Math.max(max, result);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		integerBreak(n);
	}

}
