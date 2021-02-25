package com.prac;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            
        	if(i+1 != nums.length) {
        		total = nums[i] + nums[i+1];
        		if(total == target) {
                	sum[0] = i;
                	sum[1] = i+1;
        		}
        	}
             
            
        }
        
        for(int a: sum) {
        	System.out.println(a);
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
//		int[] nums = {2, 7, 11, 15};
//		int target = 9;
		int[] nums = {3, 2, 4};
		int target = 6;
		
		twoSum(nums, target);

	}

}
