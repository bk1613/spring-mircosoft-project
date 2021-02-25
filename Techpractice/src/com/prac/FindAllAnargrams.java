package com.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnargrams {

	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Set<Character> angrams = new HashSet<>();
        
        int n = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	
        	
	        	while(n < p.length()) {
	        		if(i == s.length()-1) {
	        			break;
	        		}
	        		System.out.print(s.charAt(i+n) + " ");
		        	if(p.contains(s.charAt(i+n)+"")) {
		        		angrams.add(s.charAt(i+n));
		        	}else {
		        		break;
		        	}
		        	n++;
	        		//System.out.println(n);
	        	}
        	
        	n=0;
        	System.out.println(angrams);
        	if(angrams.size() == p.length()) {
        		list.add(i);
        	}
        	angrams.clear();
        }
        System.out.println();
        System.out.println(list);
        return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		
//		String s = "abab";
//		String p = "ab";
		
		findAnagrams(s, p);
	}

}
