package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContinousSubarraySum {

	
	public static int helper(int[] nums, int k, int i, int sum, List<Integer> li) {
		
		if(i > nums.length-1) {
			return 0;
		}
		System.out.println(sum);
		if(sum == k) {
			li.add(nums[i]);
			return 1;
		}
		//System.out.println(sum);
		int count = 0;
		for(int a = 0; a < nums.length; a++) {
			if(nums[i]==nums[a]) {
				continue;
			}
			int temp = sum + nums[a];
			
			count += helper(nums, k,i+1,temp, li);
		}
		
		return count;
	}
	
	public static boolean checkSubarraySum(int[] nums, int k) {
        
//		int n = 0;
//		List<Integer> li = new ArrayList<>();
//		n = helper(nums, k, 0, 0, li);
//		System.out.println(n);
//		System.out.println(li);
//		if(n >= 2) {
//			return true;
//		}
//		return false;
		 Map <Integer, Integer> map = new HashMap(); // key: rolling sum% k, val: array index
	        map.put(0, -1); 
	        int sum =0;
	        for(int i=0; i<nums.length; i++){
	            sum+=nums[i]; 
	            int mod = k==0? sum:sum%k; //compute sum%k
				//when map contains mod, it means that there exist an subarray from 0~j (j=map.get(mod)) where its sum%k==mod.
				//which means that subarray sum( j~i) %k==0. 
	            if(map.containsKey(mod) && i-map.get(mod)>1) return true; 
	            map.putIfAbsent(mod,i);
	        }
	        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {23, 2, 4, 6, 7};
		int k = 42;
		
		System.out.println(checkSubarraySum(nums, k));
	}

}
