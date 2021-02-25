package com.prac;

import java.util.ArrayList;
import java.util.List;

public class OneAndZero {

	public static int helper(String[] strs, int m, int n, int i, int max, List<String> list) {
		
		if(i > strs.length-1) {
			
			return list.size();
		}
		
		int count1s = 0;
		int count0s = 0;
		
		for(int j = 0; j < strs[i].length(); j++) {
			if(strs[i].charAt(j) == '0') {
				count0s++;
			}else {
				count1s++;
			}
			
		}
		
		if(count0s <= m && count1s <= n) {
			list.add(strs[i]);
			max = Math.max(max, helper(strs,  m, n, i+1, list.size(), list));
			list.remove(list.size()-1);
		}else {
			max = Math.max(max, helper(strs,  m, n, i+1, list.size(), list));
		}
		return max;
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
        int subsetsize = 0;
        subsetsize = helper(strs, m, n, 0, 0, new ArrayList<>());
        return subsetsize;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"10","0001","111001","1","0"};
		int m = 5;
		int n = 3;
	
		System.out.println(findMaxForm(strs, m, n));
	}

}
