package com.prac;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {

	/*
	Minimum Window Substring

	Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	Example:
	Input: S = "ADOBECODEBANC", T = "ABC"
	Output: "BANC"
	Note:
	•    If there is no such window in S that covers all characters in T, return the empty string "".
	•    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
	 */
	static String sj = "asfdhfgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjd";
	public static void findMinString(String S, String T, int i, List<String> str) {
		
		if(i > S.length()-1) {
			return;
		}

		int count = 0;
		
		for(int j = 0; j < T.length(); j++) {
			
			if(str.contains(T.charAt(j)+"")) {
				count++;
			}
			
		}
		//System.out.println(str + " " + count);
		if(count == T.length()) {
			String g = "";
			for(int a = 0; a < str.size(); a++) {
				g += str.get(a);
			}
			//System.out.println(g);
			if(sj.length() == g.length()) {
				//System.out.println(g);
				sj = g;
				return;
			}
			if(g.length() < sj.length()) {
				sj = g;
			}
			
			return;
		}
		
		for(int j = i; j < S.length(); j++) {
			str.add(S.charAt(j)+"");
			findMinString(S, T, i+1, str);
			str.remove(0);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		String S = "ADOBECODEBANC";
		String T = "ABC";
		findMinString(S, T, 0, new ArrayList<>());
		System.out.println(sj);
		
	}

}
