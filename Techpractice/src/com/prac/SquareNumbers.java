package com.prac;

public class SquareNumbers {

	public boolean judgeSquareSum(int c) {
     
		for(int i = 0; i <= c;i++) {
			for(int j = 0; j <= c; j++) {
				int tot = (i*i) + (j*j);
				if(tot == c) {
					return true;
				}
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareNumbers s = new SquareNumbers();
		;
		System.out.println(s.judgeSquareSum(5));
	}

}
