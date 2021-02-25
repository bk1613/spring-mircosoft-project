package com.prac;

public class IntegerReplacement {
	
	public static int replace(int n) {
		
		
		
		if(n == 1) {
			System.out.print(n);
			return 0;
		}
		System.out.print(n + " -> ");
		
		return replace(n/2) + 1;
	}
	
	public static int integerReplacement(int n) {
		int re = 0;
		if(n%2 == 0) {
			re = replace(n);
		}else {
			re = 1 + Math.min(replace(n+1),replace(n-1));
		}
		System.out.println();
		
		return re;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(integerReplacement(1234));
	}

}
