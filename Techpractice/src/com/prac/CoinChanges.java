package com.prac;

import java.util.Arrays;

public class CoinChanges {

//	public static int helper(int[] coins, int amount, int sum, int min) {
//		
//		if(amount < sum) {
//			return 0;
//		}
//		
//		if(amount == sum) {
//			return 1;
//		}
//		
//		
//		
//		int count = 0;
//		for(int i = 0; i <coins.length; i++) {
//			
//			 count += helper(coins, amount, sum+coins[i], min);
//			
//			min = Math.min(min, count);
//		}
//		
//		
//		return min;
//	}
	
	public static int coinChange(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		int[] dp = new int[amount+1];
		 
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0]=0;
	 
	    for(int i=0; i<=amount; i++){
	        if(dp[i]==Integer.MAX_VALUE){
	            continue;
	        }
	 
	        for(int coin: coins){
	            if(i<=amount-coin){ //handle case when coin is Integer.MAX_VALUE
	                dp[i+coin] = Math.min(dp[i]+1, dp[i+coin]);
	            }
	        }
	    }
	 
	    if(dp[amount]==Integer.MAX_VALUE){
	        return -1;
	    }
	 
	    return dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		coinChange(coins, amount);
		
	}

}
