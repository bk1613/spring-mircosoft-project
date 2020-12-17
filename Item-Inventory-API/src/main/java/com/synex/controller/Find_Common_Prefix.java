package com.synex.controller;

public class Find_Common_Prefix {

	
//	Longest Common Prefix
//	Write a function to find the longest common prefix string amongst an array of strings.
//	If there is no common prefix, return an empty string "".
//	Example 1:
//	Input: ["flower","flow","flight"]
//	Output: "fl"
//	Example 2:
//	Input: ["dog","racecar","car"]
//	Output: ""
//	Explanation: There is no common prefix among the input strings.
//	Note:
//	All given inputs are in lowercase letters a-z.
	
	public int findMinLength(String arr[], int n) {
		int min = Integer.MAX_VALUE;
		for(int i = n-1 ;i > 0; i--) {
			if(arr[i].length() < min) {
				min = arr[i].length();
			}
		}
		return min;
	}
	
	public String scannPrefix(String s1, String s2s) {
		return "";
		
	}
	
	public void findCommonPrefix(String arr[]) {
		String prefix = "";
		int n = arr.length;
		
		int ind = findMinLength(arr, n);
		System.out.println(ind);
		
		String thisstring = arr[ind];
		
		for(String str: arr) {
			prefix = scannPrefix(thisstring, str);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in = {"flower","flow","flight"};
		Find_Common_Prefix fcp = new Find_Common_Prefix();
		fcp.findCommonPrefix(in);
		
		
	}

}
