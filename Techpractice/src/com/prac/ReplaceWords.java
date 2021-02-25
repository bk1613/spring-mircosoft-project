package com.prac;

import java.util.List;

public class ReplaceWords {
	
	public static String replaceWords(List<String> dictionary, String sentence) {
        String newsentence = "";
        
        String[] sen = sentence.split(" ");
        
        for(String s: sen) {
        	String prev = "";
        	boolean ch = true;
        	String temp = "";
        	for(int i = 0; i < s.length(); i++) {
        		temp += s.charAt(i);
        		for(String di: dictionary) {
        			if(temp.equals(di)) {
        				if(prev.equals("")) {
        					prev = di;
        				}else {
        					int com = prev.compareTo(di);
        					if(com > 0) {
        						prev = di;
        					}
        				}
        				ch = false;
        			}
        		}
        		
        	}
        	if(!ch) {
        		newsentence += prev + " ";
        	}
        	if(ch)
        	newsentence += temp + " ";
        }
        System.out.println(newsentence);
        return newsentence.trim();
    }

	public static void main(String[] args) {
		
//		List<String> dictionary = List.of("cat","bat","rat");
//		String sentence = "the cattle was rattled by the battery";
		
//		List<String> dictionary = List.of("a","b","c");
//		String sentence = "aadsfasf absbs bbab cadsfafs";
		
//		List<String> dictionary = List.of("a", "aa", "aaa", "aaaa");
//		String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
		
//		List<String> dictionary = List.of("catt","cat","bat","rat");
//		String sentence = "the cattle was rattled by the battery";
		
		List<String> dictionary = List.of("ac","ab");
		String sentence = "it is abnormal that this solution is accepted";
		
		replaceWords(dictionary, sentence);
	}

}
