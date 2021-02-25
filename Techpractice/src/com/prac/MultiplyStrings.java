package com.prac;

public class MultiplyStrings {

	public static String multiple(String num1, String num2) {
		
		int count1 = 0;
		int count2 = 0;
		
		String a = "";
		String b = "";
		
		while(!a.equals(num1)) {
			count1++;
			a = ""+count1;
			
		}
		
		while(!b.equals(num2)) {
			count2++;
			b = ""+count2;
		}
		
		return ""+(count1*count2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiple("123", "456"));
	}

}
