package com.prac;

import java.util.Arrays;

public class Heaters {

	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int result = Integer.MIN_VALUE;
		
		for(int i = 0; i < houses.length; i++) {
			int pos = houses[i];
			int index = findHeater(heaters, pos);
			if(index==-1) result = Math.max(heaters[0]-pos,result);
            else if(index==heaters.length-1) result = Math.max(pos-heaters[heaters.length-1],result);
            else result = Math.max(result,Math.min(pos-heaters[index],heaters[index+1]-pos));
		}
		
		return result;
        
    }
	
	private static int findHeater(int[] heaters, int pos) {
		int start = 0;
		int end = heaters.length-1;
		while(start<end) {
			int mid = start+(end-start)/2+1;
			if(heaters[mid]<=pos) {
				start = mid;
			}else {
				end = mid-1;
			}
		}
		if(heaters[start]<=pos) {
			return start;
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = {1,2,3};
		int[] heaters = {2};
		
		System.out.println(findRadius(houses, heaters));
	}

}
