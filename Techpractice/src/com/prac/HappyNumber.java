package com.prac;

public class HappyNumber {

	public static boolean findhappyNumber(int num) {
		
		String strnum = num+"";
		
		int total = 0;
		
		for(int i = 0; i< strnum.length(); i++) {
			
			total += Math.pow(Integer.parseInt(strnum.charAt(i)+""), 2);
			
		}
		
		
		if(total == 1) {
			return true;
		}
		
		try {
			return findhappyNumber(total);
		}catch(StackOverflowError e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(findhappyNumber(19));
		System.out.println(findhappyNumber(7));
		System.out.println(findhappyNumber(116));
		System.out.println(findhappyNumber(73));
		System.out.println(findhappyNumber(130));
	}

}
