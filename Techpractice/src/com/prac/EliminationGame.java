package com.prac;

import java.util.ArrayList;
import java.util.List;

public class EliminationGame {

	public static int lastRemaining(int n) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}

		while(list.size() > 1) {
			for(int i = 0; i < list.size(); i+=1) {
				list.remove(i);
			}
			
			for(int i = list.size()-1; i > 0; i-=2) {
				list.remove(i);
			}
			System.out.println(list.size());
		}
		
		int result = list.get(0);
		System.out.println(result);
		return result;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lastRemaining(9);
	}

}
