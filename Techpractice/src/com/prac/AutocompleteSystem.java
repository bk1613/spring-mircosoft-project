package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutocompleteSystem {

	String[] sentence;
	int[] times;
	
	String histroicalsentence = "";
	
	public AutocompleteSystem(String[] sentence, int[] times) {
		super();
		this.sentence = sentence;
		this.times = times;
	}
	
	public List<String> input(char c){
		histroicalsentence+=c;
		List<String> list = new ArrayList<>();
		List<Integer> intlist = new ArrayList<>();
		
		for(int i =0; i < sentence.length; i++) {
			String temp = "";
			for(int j = 0; j < sentence[i].length(); j++) {
				temp += sentence[i].charAt(j);
				//System.out.println(temp + " | " + histroicalsentence);
				if(temp.equals(histroicalsentence)) {
					
					
					if(list.size()==0) {
						list.add(sentence[i]);
						intlist.add(times[i]);
					}else {
						int co = 0;
						
						if(intlist.get(list.size()-1) > times[i]) {
							
							list.add(sentence[i]);
							intlist.add(times[i]);
							
						}else if(intlist.get(list.size()-1) == times[i]){
							int com = list.get(list.size()-1).compareTo(sentence[i]);
							
							if(com > 0) {
								list.remove(list.size()-1);
								intlist.remove(list.size()-1);
								list.add(sentence[i]);
								intlist.add(times[i]);
							}
							
							
						}
					}
					break;
					
				}
			}
			//System.out.println(s);
		}
		if(list.size() > 3) {
			list = list.subList(0, 4);
		}
		System.out.println(list);
		return list;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sent = "i love you#island#ironman#i love leetcode";
		AutocompleteSystem auto = new AutocompleteSystem(sent.split("#"), new int[] {5,3,2,2});
		
		
		String commands = "i a#as";
		for(char c: commands.toCharArray()) {
			if(c == '#') {
				break;
			}
			auto.input(c);
		}
		System.out.println(auto.histroicalsentence);
		
	}

}
