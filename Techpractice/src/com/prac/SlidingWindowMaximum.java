package com.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {

	public static List<Integer> findmaxlist(int[] arr, int k){
		
		List<Integer> maxlist = new ArrayList<Integer>();
		Queue<Integer> que = new LinkedList<>();
		
		int max = 0;
		for(int i = 0; i < k; i++) {
			que.add(arr[i]);
			max = Math.max(arr[i], max);
		}
		maxlist.add(max);
		
		for(int i = k; i < arr.length; i++) {
			
//			que.poll();
//			que.add(arr[i]);
//			for(int j: que) {
//				max = Math.max(j, max);
//			}
			max = Math.max(arr[i], max);
			maxlist.add(max);
		}
		System.out.println(maxlist);
		
		
		return maxlist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		findmaxlist(nums, k);
	}

}
