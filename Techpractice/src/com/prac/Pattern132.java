package com.prac;

import java.util.ArrayList;
import java.util.List;

public class Pattern132 {

	public static boolean helper(int nums[], int a, int maxsubsequnce, List<Integer> sub) {
		
		
		if(a >= nums.length) {
			return false;
			
		}
		
		
		boolean pat = false;
		for(int d = 0; d < nums.length; d++) {
			sub.add(d);
			if(sub.size() < maxsubsequnce) {
				pat = helper(nums, d+1, maxsubsequnce, sub);
				if(pat == true) {
					break;
				}
			}else {
				int i = sub.get(0);
				int j = sub.get(1);
				int k = sub.get(2);
				
				if(i < j && j < k) {System.out.println(i + " " + k + " " + j);
					if(nums[i] < nums[k] && nums[k] < nums[j]) {System.out.println("order "+nums[i] + " " + nums[k] + " " + nums[j]);
						pat = true;
					}
				}
				
				
			}
			sub.remove(sub.size()-1);
		}
		
		
		return pat;
	}
	
	public static boolean find132pattern(int[] nums) {
        int maxsequnce = 3;
        
       boolean tr =  helper(nums, 0, maxsequnce, new ArrayList<>());
        System.out.println(tr);
        
		return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,3,2,0};
		find132pattern(nums);
	}

}
