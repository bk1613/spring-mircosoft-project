package com.prac;

import java.util.HashMap;

public class ContiguousArray {

	
	
	public static int helper(int[] nums, int i, int num1s, int num0s, int max) {
		
		if(i > nums.length-1) {
			return 0;
		}
		
		
		
		for(int j = i; j < nums.length; j++) {
			
			if(nums[j] == 1) {
				num1s++;
			}else {
				num0s++;
			}
			
			if(num1s == num0s) {
				int result = num1s + num0s;
				System.out.println(num1s + " " + num0s + " " + i);
				helper(nums, i+1, num1s, num0s, max);
				//System.out.println(result);
				max = Math.max(result, max);
				
			}
		}
		
		return max;
	}
	
	public static int findMaxLength(int[] nums) {
		
		//int result = helper(nums, 0 , 0, 0, 0);
        //return result;
		HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLen = 0;
        
        for(int idx = 0; idx < nums.length; idx++){
            sum += nums[idx] == 1 ? 1 : -1;
            
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, idx - map.get(sum));
            }else{
                map.put(sum, idx);
            }
        }
        
        return maxLen;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1, 0, 0, 1, 1};
		System.out.println(findMaxLength(nums));
	}

}
