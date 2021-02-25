package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

public class PrefixHierarchy {

	public static int[] findprefix(String[] names, String[] query) {
		int count = 0;
		int[] result = new int[query.length];
		for(int i = 0; i<query.length; i++) {
			for(int j = 0; j < names.length; j++) {
				
				if(query[i].equals(names[j])) {
					
					continue;
				}else {
					
					char[] arr = names[j].toCharArray();
					boolean a = true;
					
					for(int k = 0; k < query[i].length(); k++) {
						
						if(arr[k] != query[i].charAt(k) ) {
							a = false;
							break;
						}
					}
					if(a) {
						count++;
					}
				}
				
			}
			result[i] = count;
			count = 0;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"jackson", "jacques", "jack"};
		String[] query = {"jack", "jac"};
		int [] ar = findprefix(names, query);
		for(int i: ar) {
			System.out.print(i + " ");
		}
	}

}
