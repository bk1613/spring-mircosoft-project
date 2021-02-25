package com.prac;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

	public static List<List<Integer>> activeitySelect(List<List<Integer>> list) {
		
		List<List<Integer>> newlist = new ArrayList<>();
		
		List<Integer> li = list.get(0);
		
		newlist.add(li);
		for(int i = 1; i < list.size(); i++) {
			boolean bool = true;
//			System.out.println(list.get(i).get(0) + " " + list.get(i).get(li.size()-1));
			for(int j = list.get(i).get(0); j < list.get(i).get(li.size()-1); j++) {
//				System.out.print(j + " ");
				if(li.get(0) < j && j < li.get(li.size()-1)) {
					bool = false;
					break;
				}
				
			}
			
			if(bool) {
				newlist.add(list.get(i));
				li = list.get(i);
			}
			
		}
		System.out.println(newlist);
		return newlist;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = List.of(
				List.of(1,4),
				List.of(3,5),
				List.of(0,6),
				List.of(5,7),
				List.of(3,8),
				List.of(5,9),
				List.of(6,10),
				List.of(8,11),
				List.of(8,12),
				List.of(2,13),
				List.of(12,14)
				);
		activeitySelect(list);
	}

}
