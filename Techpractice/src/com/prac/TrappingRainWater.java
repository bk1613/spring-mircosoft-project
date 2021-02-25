package com.prac;

public class TrappingRainWater {

	public static int trapwater(int[] arr) {
		
		
		int pre = 0;
		int raincount = 0;
		for(int i = 0; i < arr.length; i++) {
			
			if(pre <= arr[i]) {
				raincount += arr[i];
				pre = arr[i];
			}
			
			
			
			
		}
		System.out.println(raincount);
		return raincount;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		trapwater(arr);
	}

}
