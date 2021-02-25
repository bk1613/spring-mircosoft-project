package com.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Kdiffpairs {

	
	public static int findPairs(int[] nums, int k) {
		
		Map<Integer, Integer>  map = new HashMap<>();
		if(nums.length == 0 || k<0)
            return 0;
        int count=0;
        for(int n : nums) {
        	System.out.println(n + " " + (map.getOrDefault(n,0) + 1));
            map.put(n, map.getOrDefault(n,0) + 1);
        }
		
		for(int key: map.keySet()) {
			if(k==0) {
                if(map.get(key)>=2)
                    count++;
            }
            else {
                
                if(map.containsKey(key+k))
                    count++;
            }
			
		}
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,4,4,3,3,0,9,2,3};
		int k = 3;
		
		System.out.println(findPairs(nums, k));
	}

}
