package com.synex.controller;

public class MaximumSubArraySum {

	public static void findmaxsum(int[] arr, int n) {
		
		int k =0;
		int max = 0;
		int sum = 0;
		int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			int j = k;
			for(; j < n; j++) {
				
				if(j == arr.length) {
					break;
				}
				
				sum += arr[j];
				
				
			}
			System.out.println("temp: "+temp + " sum: " + sum + " max: " + max);
			
			
			if(sum > temp && max < sum ) {

				max = sum;
			}
			temp = sum;
			sum = 0;
			
			k++;
			n++;
		}
		
		System.out.println(max);
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int numsub = 5;
		
		findmaxsum(arr, numsub);
		
	}

}
