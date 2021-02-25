package com.prac;

import java.util.ArrayList;
import java.util.List;

public class SingleElemenySorted {

	public static int singleNonDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			
			if(list.size() != 0) {
				
				if(list.get(list.size()-1) != nums[i]) {
					
					int len = count;
					if(count > 1) {
						if(list.size() > count) {
							for(int j = 0; j < len; j++) {
								
								
								list.remove(count--);
							}
						}else {
							for(int j = 0; j < len; j++) {
								count--;
								
								list.remove(count);
							}
						}
					}else {
						
						count = 0;
					}

				}
				
			}
			
			list.add(nums[i]);
			count++;
			
		}
		
		for(int i = count; i > 0; i--) {
			list.remove(i);
		}
		
		System.out.println(list);
		return list.get(0);
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,3,7,7,10,11,11};
		singleNonDuplicate(nums);
	}

}
