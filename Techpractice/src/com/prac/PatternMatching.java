package com.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PatternMatching {
	
	static Set<String> possibleWords = new HashSet<String>();
	
	public static void addWordstoDictionary(String input) {
		for(int i=0; i<input.length(); i++) {
			String temp = "" + input.charAt(i);
			possibleWords.add(temp);
			for(int j=i+1; j<input.length(); j++) {
				temp+=input.charAt(j);
				possibleWords.add(temp);
			}
		}
	}
	
	public static boolean match(String input, String pattern) {
		int countA = 0;
		int countB = 0;		
		
		for(char p : pattern.toCharArray()) {
			if(p == 'a') countA++;
			else countB++;
		}
		
		if(countA == 0 || countB == 0) return true;
		
//		System.out.println("Count A: " + countA);
//		System.out.println("Count B: " + countB);
		
		//countA * x + countB * y = input.length()
		List<int[]> possibleAttempts = new ArrayList<int[]>();
		if(countA > 0) {
			for(int x=1; x<=countA; x++) {
				int y = 0;
				if((input.length() - countA * x) % countB == 0) {
					//possible word length to try
					y = (input.length() - countA * x)/countB;
//					System.out.println("Possible word length to try: a:" + x + " b: " + y );
					possibleAttempts.add(new int[] {x, y});
				}				
			}
		}
		
		
		//after determining possible x and y, we check words of that length		
		for(int[] i: possibleAttempts) {
			List<String> aWords = possibleWords.stream()
					.filter(word -> word.length() == i[0])
					.collect(Collectors.toList());
			
			List<String> bWords = possibleWords.stream()
					.filter(word -> word.length() == i[1])
					.collect(Collectors.toList());
			
			System.out.println(aWords);
			System.out.println(bWords);
						
			for(int aW=0; aW<aWords.size(); aW++) {
				String aWord = aWords.get(aW);
				String temp = "";
				for(int bW=0; bW<bWords.size(); bW++) {
					String bWord = bWords.get(bW);
					for(char c: pattern.toCharArray()) {						
						if(c == 'a') {
//							System.out.println("Adding: " + aWord);
							temp+= aWord;
							} 
						else {
//							System.out.println("Adding: " + bWord);
							temp+= bWord;
						}
					}
//					System.out.println(temp);
					if(temp.equals(input)) return true;
					else temp = "";
				}
								
			}
		}		
		
		return false;
	}
	
	public static void main(String[] args) {
		addWordstoDictionary("catcatgocatgo");
		System.out.println(match("catcatgocatgo", "aabab"));
		
		System.out.println(match("catcatgocatgo", "a"));
		
		System.out.println(match("catcatgocatgo", "ab"));
		
		System.out.println(match("catcatgocatgo", "b"));
		
		System.out.println(match("catcatgocatgo", "baabaa"));
	}
	

//	public static void pattern(String input, String a, String b) {
//		
//		int acount = a.length();
//		int bcount = b.length();
//		int count = 0;
//		String pattern = "";
//		String temp = "";
//		
//		char[] arr = input.toCharArray();
//		
//		for(int i = 0; i < arr.length; i++) {
//			//System.out.print(arr[i] + " ");
//			temp += arr[i];
//			if(temp.equals(a)) {
//				pattern += "a";
//				temp = "";
//			}else if (temp.equals(b)) {
//				pattern += "b";
//				temp = "";
//			}
//		}
//		
//		System.out.println(pattern);
//		
//	}
//	
//	public static void main(String[] args) {
//		
//		String input = "catcatgocatgo";
//		String a = "cat";
//		String b = "go";
//		String a2 = "catcatgocatgo";
//		String b2 = "";
//		String a3 = "c";
//		String b3 = "atcatgocatgo";
//		String a4 = "";
//		String b4 = "catcatgocatgo";
////		String a = "ca";
////		String b = "tcatgocatgo";
//		
//		pattern(input, a, b);
//	}

}
