package com.synex.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PalindromePermutation {

//	String permwprd;
//	
//	List<String> list = new ArrayList<>();
//	List<String> checkpalin = new ArrayList<>();
//	
//	public boolean checkPalidrome(String str) {
//		
//		String[] arr = str.split("");
//		String per = "";
//		for(int i = 0; i < arr.length; i++) {
//			if(!arr[i].equals(" ")) {
//				per += arr[i].toLowerCase();
//			}
//		}
//		//System.out.println(per);
//		int i = 0, j = per.length() - 1;
//		
//		boolean ispal = true;
//		
//		while(i < j) {
//			
//			if(per.charAt(i) != per.charAt(j)) {
//				ispal = false;
//				break;
//			}
//			
//			i++; 
//            j--; 
//		}
//		
//		return ispal;
//	}
//	
//	public void perm(String str, String ans) {
//		
//		if(str.length() == 0) {
//			list.add(ans);
//			
//			return;
//		}
//		
//		
//		
//		for(int i = 0; i < str.length(); i++) {
//			
//			char ch = str.charAt(i);
//			
//			String ros = str.substring(0, i) + str.substring(i + 1);
//			
//			perm(ros, ans + ch);
//			
//		}
//		
//		
//	}
	public static HashMap<Character, Integer> hm = new HashMap<>();
	
	public static boolean hasPalindromePermutation(String str) {				
		for(char c: str.toCharArray()) {
			if(hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			}
			else {
				hm.put(c, 1);
			}
		}
		
		int oddAppearance = 0;
		
		Iterator<Map.Entry<Character,Integer>> hmIterator = hm.entrySet().iterator();
		while(hmIterator.hasNext()) {
			Map.Entry<Character,Integer> mapElement = (Map.Entry<Character,Integer>)hmIterator.next();
			int appearance = ((int)mapElement.getValue());
			if(appearance % 2 == 1)oddAppearance++;
		}
				
		return oddAppearance <= 1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tr = "Tact coa";
//		PalindromePermutation pp = new PalindromePermutation();
//		pp.perm(tr, "");
		System.out.println(hasPalindromePermutation(tr.replaceAll("\\s", "").toLowerCase()));
		
//		pp.checkPalidrome(pp.list.get(0));
		
//		for(String s: pp.list) {
//			pp.checkPalidrome(s);
//			if(pp.checkPalidrome(s)) {
//				System.out.println(pp.checkPalidrome(s));
//				break;
//			}
//		}
//		
	}

}
