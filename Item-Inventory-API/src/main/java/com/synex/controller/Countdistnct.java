package com.synex.controller;

import java.util.HashSet;

public class Countdistnct {

	public static void distnctnumbers(int[] arr, int k, int start) {
		
		if(start > arr.length-k) {
			
			return;
		}
		
		HashSet<Integer> hs = new HashSet<>();
		int count = 0; 
		for(int i = start; i < arr.length; i++) {
			
			
			
			if(count == k) {
				break;
			}
			
			count++;
			
			hs.add(arr[i]);
		}
		
		System.out.print(hs.stream().count()+ " ");
		
		distnctnumbers(arr, k, ++start);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,1,3,4,2,3};
		int k = 4;
		
//		int[] arr = {1, 2, 4, 4};
//		int k = 2;
		distnctnumbers(arr, k, 0);
	}

}
