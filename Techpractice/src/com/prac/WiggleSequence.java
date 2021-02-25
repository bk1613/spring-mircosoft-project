package com.prac;

import java.util.ArrayList;
import java.util.List;

public class WiggleSequence {

	
	
	public static int wiggleMaxLength(int[] nums) {
        int count  = 1;
        int temp = nums[1] - nums[0];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < nums.length-1; i++) {
        	
        	if(temp > 0) {
        		
        		if(nums[i+1] - nums[i] < 0) {
        			temp = nums[i+1] - nums[i]; 
        			list.add(temp);
        			count++;
        		}else {
        			temp = nums[i+1] - nums[i]; 
        			list.add(temp);
        			continue;
        		}

        	}else if(temp < 0) {
        		if(nums[i+1] - nums[i] > 0) {
        			temp = nums[i+1] - nums[i]; 
        			list.add(temp);
        			count++;
        		}else {
        			temp = nums[i+1] - nums[i]; 
        			list.add(temp);
        			continue;
        		}
        	}
        	
        }
        
        if(list.get(list.size()-2) > 0) {
        	if((list.get(list.size()-1) - list.get(list.size()-2)) < 0) {
        		count++;
        	}else if((list.get(list.size()-1) - list.get(list.size()-2)) > 0){
        		count++;
        	}
        }else if(list.get(list.size()-2) < 0) {
        	if((list.get(list.size()-1) - list.get(list.size()-2)) > 0) {
        		count++;
        	}else if((list.get(list.size()-1) - list.get(list.size()-2)) > 0){
        		count++;
        	}
        }
       
		
		
		
		return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 7, 4, 9, 2, 5};
		System.out.println(wiggleMaxLength(input));
		
		int[] input2 = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(wiggleMaxLength(input2));
		
		int[] input3 = {1,2,3,4,5,6,7,8,9};
		System.out.println(wiggleMaxLength(input3));
	}

}
