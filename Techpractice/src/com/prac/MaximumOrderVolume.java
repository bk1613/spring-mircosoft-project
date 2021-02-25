package com.prac;

import java.util.HashMap;
import java.util.Map;

public class MaximumOrderVolume {

	public static int phoneCalls(int[] start, int[] duration, int[] volume) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<start.length; i++) {
			map.put(start[i], volume[i]);
		}
		
		int max = 0;
		System.out.println(map);
		int c = 0;
		
		for(int i : map.keySet()) {
			int temp = 0;
			
			for(int j: map.keySet()) {
				
				if(j != i) {
					
					int i1 = map.get(i);
					int i2 = map.get(j);
					
					if(i + duration[c] < j) {
						
						temp = i1 + i2;
						
						if(temp > max) {
							max = temp;
						}
					}
					
				}
				
			}
			c++;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {10, 5, 15, 18, 30};
		int[] duration = {30, 12, 20, 35, 35};
		int[] volume = {50, 51, 20, 25, 10};
//		int[] start = new int[] {10,5,15,18,30};
//	    int[] duration = new int[] {30,12,20,35,35};
//	    int[] volume = new int[] {55,51,20,25,60};
		System.out.println(phoneCalls(start, duration, volume));
	}

}
