package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	public static void distnctsubset(int[] sub, int n) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		
		
		for(int i = 0; i < sub.length; i++) {
			List<List<Integer>> temp = new ArrayList<>();
			
			for(List<Integer> a : list) {
				System.out.println("a: "+a);
				temp.add(new ArrayList<Integer>(a));
			}
			
			for(List<Integer> a : temp) {
				a.add(sub[i]);
			}
			
			List<Integer> sing = new ArrayList<>();
			sing.add(sub[i]);
			temp.add(sing);
			
			list.addAll(temp);
		}
		
		list.add(new ArrayList<Integer>());
		
		for(List<Integer> a : list) {
			System.out.println(a);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int[] num = {1,2,3};
		
		distnctsubset(num, num.length);

	}

}
