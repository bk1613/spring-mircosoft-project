package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSeek {

	
	public static void seekWord(String[] arr, String[] name) {
		int row = arr.length;
		int col = arr[0].length();
		
		List<String> list = Arrays.asList(name);
		Map<String, List<Integer>> map = new HashMap<>();
		
		for(String n: name) {
			map.put(n, List.of(0, 0));
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				String rowStr = "";
				String colStr = "";
				for(int r = i; r < row; r++) {
					rowStr += arr[r].charAt(j);
					if(list.contains(rowStr)) {
						System.out.println(rowStr + " "+i+" "+j);
						map.put(rowStr, List.of(i, j));
						break;
					}
					
				}
				
				for(int c = j; c < row; c++) {
					colStr += arr[i].charAt(c);
					if(list.contains(colStr)) {
						System.out.println(colStr + " "+i+" "+j);
						map.put(colStr, List.of(i, j));
						break;
					}
					
				}
			}
		}
		
		for(String k: map.keySet()) {
			if(map.get(k).get(0) == 0 && map.get(k).get(1) == 0) {
				map.replace(k, List.of(-1, -1));
			}
		}
		System.out.println(map);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"ABCD", "PRAT", "KITA", "ANDY"};
		String[] name = {"ANDY", "CAT", "DOG"};
		seekWord(arr, name);
		//conflict happens when user push the same file. To resolve it we use merge
		//conflict happens when one user made changes push the code, other can't until that person revert or accept the changes of the same code and then push again
		//conflict happens when the user made changes to the code on their local computer but can't pull from repo because code from repo doesn't match, need to reset
		//to get merge tool, pull the data first
	}

}
