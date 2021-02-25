package com.synex.controller;

public class CardFlippingGame {
	
	public static boolean goodNumber(int[] front , int card) {
		for(int i : front) {
			if(i == card) return false;
			
		}
		return true;
	}

	public static boolean flip(int[] front, int[] back, int index) {
		
		if(front.length != back.length || index >= front.length || index < 0)return false;
		if(front[index] == back[index]) return false;
		
		int temp = front[index];
		front[index] = back[index];
		back[index] = temp;//back[index] contains the number we want to compare
		
		boolean b = goodNumber(front, temp);
		
		temp = front[index];
		front[index] = back[index];
		back[index] = temp;//swap back since arrays are pass by value but still can check contents
		
		
		return b;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fronts = {1,2,4,4,7};
		int[] backs = {1,3,4,1,3};
		
		//find the unique
		//check front for duplicates
		
		
		Integer min = null;
		for(int i=0; i < fronts.length; i++) {
			if(flip(fronts, backs, i)) {
				if(min == null) min = fronts[i];
				else if(min > fronts[i]) min = fronts[i];
			}
		}
		
		System.out.println(min);
	}

}
