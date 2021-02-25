package com.prac;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TopKfrequent {

	public static int[] topKFrequent(int[] nums, int k) {
		
		Set<Integer> unnums = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for(int n: nums) {
			
			map.merge(n, 1, (a,b)->a+b);
			if(map.get(n) >= k && !list.contains(n)) {
				list.add(n);
			}
		}
		System.out.println(list);
		int[] arr = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
			
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(arr[i] + " ");
			
		}
		
		return arr;

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		int k = 1;
		topKFrequent(nums, k);
	}

}
