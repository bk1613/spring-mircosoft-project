package com.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IncreasingSubsequences {
	 public static void helper(List<List<Integer>> ans, List<Integer> path, int start, int cur, int[] nums){
	        if(start >= nums.length) return;
	        for(int i=start; i<nums.length;i++){
	             if(nums[i] >= cur){
	                 path.add(nums[i]);
	                 if(path.size()>=2) ans.add(new ArrayList<>(path));
	                 helper(ans, path, i+1, nums[i], nums);
	             }
	            else if(nums[i]<cur) continue;
	            path.remove(path.size()-1);
	        }
	    }
	    public static List<List<Integer>> findSubsequences(int[] nums) {
	        List<List<Integer>> ans= new ArrayList<>();
	        if(nums==null || nums.length==0) return new ArrayList<>();
	        helper(ans, new ArrayList<>(), 0, -101, nums);
	        ans = ans.stream().distinct().collect(Collectors.toList());
	        return ans;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 6, 7, 7};
		
		System.out.println(findSubsequences(nums));

	}

}
