package com.prac;

public class MinimumSizeSubarraySum {

	public static int helper(int[] nums, int s, int sum, int n, int min) {
		
		if(n == nums.length) {
			return 0;
		}
		
		if(sum == s) {
			return 0;
		}
		
		for(int i = 0; i < nums.length; i++) {
			int result = helper(nums, s, sum+nums[i], n+1, min)+1;
			min = Math.min(min, result);
			
		}
		
		return min;
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		
		int count = 0;
		
		int n =0;
		
		int c = helper(nums, s, 0, 0, Integer.MAX_VALUE);
		
		System.out.println(c);
		return s;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 8, 4};
		int s = 16;
		minSubArrayLen(s, nums);
	}

}
