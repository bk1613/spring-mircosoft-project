package com.synex.controller;

public class IdenticalDistribution {


	
	public static void main(String[] args) {
		
//		int[] cardtypes = {3,8,7,6,4};
		int[] cardtypes = {3,9,7,6,5,2};
		
		int packet = 8;
		
		int cardsNeeded = 0;
		
		for(int i: cardtypes) {
			int current = i;

			
			while(current % packet != 0) {
				current++;
			}
			cardsNeeded += current - i;
		}
		
		System.out.println(cardsNeeded);
		
		
		
	}

}
