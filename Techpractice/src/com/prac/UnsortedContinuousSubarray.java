package com.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {
		
		boolean needascend = false;
		int count = 0;
		Set<Integer> list = new HashSet<>();
		for(int i = 0; i < nums.length; i ++) {
			
			if(i != nums.length-1) {
				if(nums[i] > nums[i+1]) {
					
					list.add(nums[i]);
					
					needascend = !needascend;
					continue;
				}
				if(needascend) {
					list.add(nums[i]);
				}
				if(i > 0) {
					if(nums[i] < nums[i-1]) {
						list.add(nums[i]);
					}
				}
			
				
			} 
		}
		System.out.println(list);
		return list.size();
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		UnsortedContinuousSubarray ucs = new UnsortedContinuousSubarray();
		
		System.out.println(ucs.findUnsortedSubarray(nums));
	}

}
