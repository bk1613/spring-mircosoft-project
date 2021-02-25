package com.synex.controller;

import java.util.HashSet;
import java.util.Set;

public class MakingUnqueFile {

	public static void checkUnique(String[] input) {
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < input.length; i++) {
			if(set.contains(input[i])) {
				int n = 1;
				while(!set.add(input[i] + "(" + n + ")")) {
					n++;
				};
				set.add(input[i] + "(" + n + ")");
			}else
				set.add(input[i]);
		}
		
		System.out.println(set);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] names = {"pes", "fifa", "gta", "pes(2019)"};
//		String[] names = {"one piece", "one piece", "kaido", "kaido(1)"};
		String[] names = {"gta", "gta", "gta(1)", "avalon"};
		checkUnique(names);
		
	}

}
