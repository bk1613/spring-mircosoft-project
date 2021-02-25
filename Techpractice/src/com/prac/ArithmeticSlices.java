package com.prac;

public class ArithmeticSlices {

	public static int helper(int[] A, int result, int prev, int end) {
		
		if(A.length == end) {
			return 0;
		}
		int t = 0;
		int count = 0;
		for(int i = 1; i < A.length; i++) {
			t = A[i] - prev;
			if(result == 0) {
				result = t;
			}
			
			if(result == t) {
				count = helper(A, t, A[i], end+1) + 1;
			}
			
		}
		
		return count;
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
        
		int start = A[0];
		
		int c = helper(A, 0, start, 0);
		System.out.println(c);
		return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3, -1, -5, -9};
		numberOfArithmeticSlices(A);
	}

}
