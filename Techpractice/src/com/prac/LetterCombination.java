package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

//	public static void dialscombine(List<String> combinations, String firstin, String secinput, int n) {
//		
//		String co = "";
//		
//		for(int i = 0; i < firstin.length(); i++) {
//			co += firstin.charAt(i);
//			for(int j = 0; j < secinput.length(); j++) {
//				co += secinput.charAt(j);
//				String temp = "";
//				for(int s = co.length()-1; s > -1 ; s--) {
//					temp += co.charAt(s);
//				}
//				
//				if(combinations.contains(temp)) {
//					temp = "";
//					continue;
//				}else if(combinations.contains(co)) {
//					co = firstin.charAt(i)+"";
//					continue;
//				}
//				//System.out.println(co);
//				if(co.length() <= n)
//					combinations.add(co);
//				co = firstin.charAt(i)+"";
//				
//			}
//			
//			co = "";
//		}
//		
//		
//	}
	
//	public static void dialscombine(List<String> combinations, int firstin, String input, int n, Map<Integer, String> map) {
//		
//		String co = "";
//		
//		for(int i = 0; i < map.get(firstin).length(); i++) {
//			co += map.get(firstin).charAt(i);
//			for(int j = 0; j < input.length(); j++) {
//				int a = Integer.parseInt(input.charAt(j)+"");
//				if(firstin == a) {
//					continue;
//				}
//				for(int s = 0; s < map.get(a).length(); s++)
//				{
//					co += map.get(a).charAt(s);
//					String temp = "";
//					for(int si = co.length()-1; si > -1 ; si--) {
//						temp += co.charAt(si);
//					}
//					
//					if(combinations.contains(temp)) {
//						temp = "";
//						continue;
//					}else if(combinations.contains(co)) {
//						temp = "";
//						co = map.get(firstin).charAt(i)+"";
//						continue;
//					}
//					if(co.length() == n) {
//						combinations.add(co);
//						co = map.get(firstin).charAt(i)+"";
//					}
//					
//				}
//				
//			}
//			
//			co = "";
//		}
//		
//		
//	}
	
	public static void dialscombine(List<String> combinations, int i, StringBuilder builder, Map<Integer, String> map, String digits) {
		
		if(i > digits.length()-1) {
			combinations.add(builder.toString());
			return;
		}
		
		char digit = digits.charAt(i);
		
		Integer button = Integer.valueOf(String.valueOf(digit));
		String alphabets = map.get(button);
		
		for(int j = 0; j < alphabets.length(); j++) {
			
			builder = builder.append(alphabets.charAt(j));
			
			dialscombine(combinations, i+1, builder, map, digits);
			
			builder.deleteCharAt(builder.length()-1);
		}
		
	}
	
	public static void combine(String input) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		
		List<String> combinations = new ArrayList<>();
		
//		for(int i = 0; i < input.length(); i++) {
//			int dial = Integer.parseInt(input.charAt(i)+"");
//			System.out.println(dial);
////			for(int j = 0; j < input.length(); j++) {
////				int dial2 = Integer.parseInt(input.charAt(j)+"");
////				if(dial == dial2) {
////					continue;
////				}
//				
////				dialscombine(combinations, map.get(dial), map.get(dial2), input.length());
//			dialscombine(combinations, dial, input, input.length(), map);
//				
////			}
//		}
		
		StringBuilder builder = new StringBuilder();
		dialscombine(combinations, 0, builder,  map, input);
		System.out.println(combinations);
	}
	
	
	public static void main(String[] args) {
		
		String input = "237";
		combine(input);

	}

}
