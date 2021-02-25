package com.prac;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

//	 public static List<Integer> grayCode(int n) {
//	      
//		 List<Integer> list = new ArrayList<Integer>();
//		 
//		 int po = 1;
//		 
//		 for(int i = 0; i < n; i++) {
//			 po *= 2;
//		 }
//
//		 for(int i = 0; i < po; i++) {
//			 list.add(i);
//		 }
//		 System.out.println(list);
//		 return list;
//	 }
	
	 
	public static List<Integer> grayCode(int n) {
	      
		if(n==0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(0);
			return list;
		}
		
		
		List<Integer> result = grayCode(n -1);
		int numToAdd = 1 <<(n-1);
//		for(int i = 0; i < n; i++) {
//			numToAdd *= 2;
//	 	}
//		System.out.println(numToAdd);
//		for(int i = 0; i < result.size(); i++) {
//			 result.add(numToAdd+result.get(i));
//		}
		System.out.println(numToAdd);
		for(int i=result.size()-1; i>=0; i--){ //iterate from last to first
	        result.add(numToAdd+result.get(i));
	    }
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		
		System.out.println(grayCode(n));
	}

}
