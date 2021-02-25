package com.synex.controller;

import java.util.HashMap;

public class PrintPossibleWords {

	public static String combos(int[] arr) {

		//switch
		switch(arr[0]) {
		case 2:
			if(arr[1] == 1) {
				return "A";
			}
			else if(arr[1] == 2) {
				return "B";
			}
			else if(arr[1] == 3) {
				return "C";
			}
			
		case 3:
			if(arr[1] == 1) {
				return "D";
			}
			else if(arr[1] == 2) {
				return "E";
			}
			else if(arr[1] == 3) {
				return "F";
			}
			
		case 4:
			if(arr[1] == 1) {
				return "G";
			}
			else if(arr[1] == 2) {
				return "H";
			}
			else if(arr[1] == 3) {
				return "I";
			}
			
		case 5:
			if(arr[1] == 1) {
				return "J";
			}
			else if(arr[1] == 2) {
				return "K";
			}
			else if(arr[1] == 3) {
				return "L";
			}
		
		case 6:
			if(arr[1] == 1) {
				return "M";
			}
			else if(arr[1] == 2) {
				 return "N";
			}
			else if(arr[1] == 3) {
				return "O";
			}
			
		case 7:
			if(arr[1] == 1) {
				return "P";
			}
			else if(arr[1] == 2) {
				return "Q";
			}
			else if(arr[1] == 3) {
				return "R";
			}
			else if(arr[1] == 4) {
				return "S";
			}
			
		case 8:
			if(arr[1] == 1) {
				return "T";
			}
			else if(arr[1] == 2) {
				return "U";
			}
			else if(arr[1] == 3) {
				return "V";
			}
			
		case 9:
			if(arr[1] == 1) {
				return "W";
			}
			else if(arr[1] == 2) {
				return "X";
			}
			else if(arr[1] == 3) {
				return "Y";
			}
			else if(arr[1] == 4) {
				return "Z";
			}
			
		default:
			return "";
			
		}
		
	}
	
	public static void printphone(int[][] arr) {
		String str = "";
		for(int[] a: arr) {
			str += combos(a);
		}
		
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inputarray = {{2, 2}, {3, 3}, {2, 1}, {5, 2}, {8, 1}, {7, 4}};
		printphone(inputarray);
		
	}

}
