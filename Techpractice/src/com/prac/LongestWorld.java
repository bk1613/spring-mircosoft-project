package com.prac;

import java.util.List;

public class LongestWorld {

	static String currword;
	static int a = 0;
	public static void helper(String s, List<String> d, int i, StringBuilder longword) {
		
		if(i > s.length()-1 || a > d.size()-1) {
			return;
		}
		
		if(d.get(a).equals(longword.toString())) {
			System.out.println(d.get(a));
			
			if(currword == null) {
				currword = longword.toString();
			}else if(currword.length() < longword.length()) {
				currword = longword.toString();
			}
			//helper(s, d, i+1, a+1, longword);
			a++;
			return;
		}
		
		for(int j =0; j < s.length(); j++) {
			longword.append(s.charAt(j));
			helper(s, d, i+1,  longword);
			
			longword.delete(longword.length()-1, longword.length());
		}
		
	}
	
	
	public static String findLongestWord(String s, List<String> d) {
       
		StringBuilder longword = new StringBuilder();
		helper(s,d,0,longword);
		String sa = currword;
		if(currword.length() < d.get(d.size()-1).length()) {
			sa = d.get(d.size()-1);
		}
		return sa;
		
    }
	
	public static void main(String[] args) {
		String s = "abpcplea";
		List d = List.of("ale","apple","monkey","plea");
		System.out.println(findLongestWord(s, d));
	}

}
