package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateletters {

	/*
		Remove Duplicate Letters
		Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
		You must make sure your result is the smallest in lexicographical order among all possible results.
		
		Example 1:
		Input:"bcabc"
		Output:"abc"
		
		Example 2:
		Input:"cbacdcbc"
		Output:"acdb"
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String letter = "bcabc";
		String letter = "cbacdcbc";
		
		String nonedup = "";
		int idx =0;
		List<String> li = new ArrayList<>();
		
		char[] cahrarry = letter.toCharArray();
		
		for(int i = 0; i < cahrarry.length; i++) {
			String temp = "" + cahrarry[i];
			
			if(li.contains(temp)) {
				
				li.remove(temp);
				li.add(temp);
				
			}else {
				
//				nonedup+=temp;
//				System.out.println(nonedup);
				li.add(temp);
				
			}
			
		}
		
		li.forEach(System.out::print);
	}

}
