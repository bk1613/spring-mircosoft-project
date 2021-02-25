package com.prac;

public class GuessNumber {

	static int pick;
	
	public static int guess(int num) {
		if(pick < num) {
			return -1;
		}else if(pick > num) {
			return 1;
		}else {
			return 0;
		}
		
		
	}
	
	public static int guessNumber(int n) {
		int result = 0;
        for(int i = 1; i <= n; i++) {
        	if(guess(i) ==0) {
        		
        	
        		result = i;
        	}
        	
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		pick = (int)(Math.random()*10);
		System.out.println(guessNumber(n));
	}

}
