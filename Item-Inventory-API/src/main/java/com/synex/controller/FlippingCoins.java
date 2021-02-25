package com.synex.controller;

import java.util.Scanner;

public class FlippingCoins {

	/*
			     T T T T
		103    T T T T ->0
		012    T H H T
		101    T H   ->1
		100    T -> 0
		003    H T T H 
		103    H T T H  -> 2
		133          H -> 1
	 */
	
	public static void flip(String[] coins, int commands) {
		
		Scanner in = new Scanner(System.in);
		
		for(int i = 0; i < commands; i++) {
			int coundhead = 0;
			
			System.out.println("Flip:");
			String line = in.nextLine();
			
			int curCommand = Character.getNumericValue(line.charAt(0));
			int A = Character.getNumericValue(line.charAt(2));
			int B = Character.getNumericValue(line.charAt(4));
			
			
			
			
			if(curCommand == 0) {
				for(int j = A; j <= B;j++) {
					if(coins[j] == "T") {
						coins[j] = "H";
					}else {
						coins[j] = "T";
					}
				}
			}else {
				for(int j = A; j <= B;j++) {
					if(coins[j] == "T") {
						continue;
					}else {
						coundhead++;
					}
				}
				System.out.println("Number of Heads: \n"+coundhead);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberofcoins = 4;
		int numberofcommands = 7;
		
		String[] coins = {"T", "T", "T", "T"};
		flip(coins, numberofcommands);
		
	}

}
