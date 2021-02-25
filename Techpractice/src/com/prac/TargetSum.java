package com.prac;

public class TargetSum {

//	public static int findTargetSumWays(int[] nums, int S) {
//        
//		int count = 0;
//		for(int i = 0; i < nums.length; i++) {
//			int sum = 0;
//			for(int j = 0; j < nums.length; j++) {
//				if(i == j) {
//					sum -= nums[j];
//				}else {
//					sum += nums[j];
//				}
//				
//			}
//			if(sum == S) {
//				count++;
//			}
//		}
//		return count;
//    }
	public static int findTargetSumWays(int[] nums, int S) {
		//[1, 1, 1, 1, 1], S is 3.
	   int n = nums.length;
	   int cur = S;     
	   return helper(nums,S,cur, 0,0);
	}

	private static int helper(int[] nums,int sum, int cur, int index,int count)
	{
		int n = nums.length;
		if(index==n && cur ==0){
			count++;
		}
		if(index == n ){
			return count;
		}
		//need to pararallely + , - value.
		count = helper(nums,sum,cur-nums[index],index+1,count);
		count =helper(nums,sum,cur+nums[index],index+1,count) ;

		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 1, 1};
		int sum = 3;
		
		System.out.println(findTargetSumWays(nums, sum));

	}

}
