package com.prac;

public class RotateFunction {

	public static int maxRotateFunction(int[] A) {
       
		int k = 0;
		int result = 0;
		int max = 0;
		for(int i = 0; i < A.length; i++) {
			
			for(int j = 0; j < A.length; j++) {
				
				System.out.print((A[k]*j) + " ");
				result += j * A[k];
				k++;
				
				if(k == A.length) {
					k = 0;
				}
				
			}
			
			System.out.println();
			k=(A.length-1)-i;
			max = Math.max(max, result);
			result = 0;
		}
		System.out.println(max);
		
		return 0;
    }
	
	public static void main(String[] args) {
		int[] A = {4, 3, 2, 6};
		maxRotateFunction(A);
	}

}
