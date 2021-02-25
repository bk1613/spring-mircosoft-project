package com.prac;

import java.util.Stack;

public class NextGreaterElement {
	
	private static void process(int[] nums, int[] result, Stack<Integer> stack, boolean push) {
        
        for (int i = 0; i < nums.length; i++) {
            
           while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    
                result[stack.pop()] = nums[i];
            }
                
            if (push)
            stack.push(i);
        }
    }
	
	public static int[] nextGreaterElements(int[] nums) {
        
		if(nums[0] != nums[nums.length-1]) {
			return nums;
		} 
		
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                
				result[stack.pop()] = nums[i];
            }
			if(stack.isEmpty()) {
				
				result[i] = -1;
			}
			stack.push(i);
		}


        result[result.length-1] = result[0];
       
        for(int i: result) {
        	System.out.println(i);
        }
        return result;
		
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1};
		nextGreaterElements(nums);
	}

}
