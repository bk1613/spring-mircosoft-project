package com.prac;

public class PredictTheWinner {

	public static boolean PredictTheWinner(int[] nums) {
        
		int total = 0;
		
		for(int val: nums) {
			total += val;
		}
		
		int[][] dp = new int[nums.length][nums.length];
		
		for(int i =0; i < dp.length; i++) {
			for(int g=0,j=i;j<dp.length;g++,j++){
				if(i==0) {
					dp[g][j] = nums[g];
				}else if(i == 1) {
					dp[g][j] = Math.max(nums[g], nums[j]);
				}else {
				int val1=nums[g]+Math.min(dp[g+2][j],dp[g+1][j-1]);
				int val2=nums[j]+Math.min(dp[g+1][j-1],dp[g][j-2]);
                dp[g][j]=Math.max(val1,val2);
				}
			}
		}
		
		
		int p1score=dp[0][nums.length-1]; //max score of player 1 that he is able to get
        int p2score=total-dp[0][nums.length-1]; //player 2 score
        return p1score>=p2score;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1, 5, 2};
		
		System.out.println(PredictTheWinner(nums));
	}

}
