package com.synex.controller;

import java.util.HashMap;

public class WordBreak {

	HashMap<Integer, String> hm =  new HashMap<>();
		
	public boolean canWordBreak(String word) {
		
		int idx = 0;
		String temp = null;
		for(int i = 0; i<word.length(); i++) {
			temp = word.substring(idx, i+1);
			if(this.hm.containsValue(temp)) {
				
				idx=i+1;
			}else {
				if(i == word.length()-1) {
					return false;
				}else {
					continue;
				}
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "leetcode";
		String[] wordDict1 = {"leet", "code"};
		WordBreak wb1 = new WordBreak();
		
		String s2 = "applepenapple";
		String[] wordDict2 = {"apple", "pen"};
		WordBreak wb2 = new WordBreak();
		
		String s3 = "catsandog";
		String[] wordDict3 = {"cats", "dog", "sand", "and", "cat"};
		WordBreak wb3 = new WordBreak();
		
		for(int i= 0; i < wordDict1.length; i++) {
			wb1.hm.putIfAbsent(i, wordDict1[i]);
		}
		System.out.println("leetcode is "+wb1.canWordBreak(s1));
		
		for(int i= 0; i < wordDict2.length; i++) {
			wb2.hm.putIfAbsent(i, wordDict2[i]);
		}
		System.out.println("applepenapple is "+wb2.canWordBreak(s2));
		
		for(int i= 0; i < wordDict3.length; i++) {
			wb3.hm.putIfAbsent(i, wordDict3[i]);
		}
		System.out.println("catsandog is "+wb3.canWordBreak(s3));
	}

}
