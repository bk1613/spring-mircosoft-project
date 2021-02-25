package com.prac;

public class FindTheSubstring {

	public static int findSubstring(String s, String x) {
		
		char firstocur = ' ';
		boolean firt = true;
		int noAstrick = 0;
		
		for(int j = 0; j < x.length(); j++) {
			if(x.charAt(j) == '*') {
				noAstrick++;
			}else {
				break;
			}
		}
		
		if(noAstrick == x.length()) {
			return -1;
		}
		
		System.out.println(noAstrick + " " +x.charAt(noAstrick));
		System.out.println(x.length() - noAstrick);
		
		for(int i =0; i<s.length();i++) {
			
			
			if(s.charAt(i) == x.charAt(noAstrick)) {
				System.out.println("i: "+ i);
				firstocur = s.charAt(i- noAstrick);
				firt = true;
				break;
			}else {
				firt = false;
			}
		}
		
		if(!firt) {
			return -1;
		}
		
		System.out.println("firstocur: "+firstocur);
		
		int ind = s.indexOf(firstocur);
		int c = 0;
		int temp = ind;
		
		for(; temp < s.length(); temp++) {
			
			if(x.charAt(c) == s.charAt(temp) || x.charAt(c) == '*') {
				if(c == x.length()-1) {
					break;
				}
				c++;
			}else {
				return -1;
			}

		}
		
		return ind;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "xabcdey";
		String x = "*b*d";
//		String x;
		System.out.println(findSubstring(s, x));
	}

}
