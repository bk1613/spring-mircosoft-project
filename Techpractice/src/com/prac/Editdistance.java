package com.prac;

public class Editdistance {

	public static int helper(String word1, String word2, int m, int n) {
		
		if(m == 0 || n == 0) {
			return 0;
		}
		
		if(word1.charAt(m-1) == word2.charAt(n-1)) {
			return helper(word1, word2, m-1, n-1);
		}
		
		int min1 = Math.min(helper(word1, word2, m-1, n), helper(word1, word2, m, n-1));
		int min2 = Math.min(helper(word1, word2, m-1, n-1), helper(word1, word2, m, n-1));
		int min3 = Math.min(helper(word1, word2, m-1, n), helper(word1, word2, m-1, n-1));
		
		if(min1 < min2 || min1 < min3) {
			return 1 + min1;
		}else if(min2 < min1 || min2 < min3) {
			return 1 + min2;
		}else {
			return 1 + min3;
		}
		
	}
	
	public static int editdistance(String word1, String word2) {
		
		if(word1.length() == 0 || word2.length() ==0) {
			return 0;
		}
		
		int result = helper(word1, word2, word1.length(), word2.length()) + 1;
		
		return result;
	}
	
	
	public static void main(String[] args) {
//		String word1 = "horse";
//		String word2 = "ros";
		
		String word1 = "intention";
		String word2 = "execution";
		
		System.out.println(editdistance(word1, word2));
	}

}
