package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WebsitePagination{

	public static void sortpage(List<List<String>> items, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {
		
	
		if(sortOrder == 0) {
			if(sortParameter == 0) {
				items.sort((it1, it2)-> it1.get(sortParameter).compareTo(it2.get(sortParameter)));
			}else {
				items.sort((it1, it2)-> Integer.valueOf(it1.get(sortParameter)).compareTo(Integer.valueOf(it2.get(sortParameter))));
			}
			
			
		}else {
			
			if(sortParameter == 0) {
				items.sort((it1, it2)-> it2.get(sortParameter).compareTo(it1.get(sortParameter)));
			}else {
				items.sort((it1, it2)-> Integer.valueOf(it2.get(sortParameter)).compareTo(Integer.valueOf(it1.get(sortParameter))));
			}
			
		}
		System.out.println(items);
		int page = 1;
		int noItems = 0;
		for(int i = 0; i < items.size(); i++) {
			
			if(page == pageNumber) {
				System.out.println(items.get(i).get(0));
			}
			noItems++;
			if(noItems == itemsPerPage) {
				page++;
				noItems = 0;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		String[][] items = {{"item1", "10", "15"}, {"item2", "3", "4"}, {"item3", "17", "8"}};
		List<List<String>> itemslist = new ArrayList<>();
		
		int sortParameter = 1;
		int sortOrder = 0;
		int itemsPerPage = 2;
		int pageNumber = 1;
		
		for(int i = 0; i < items.length; i++) {
			itemslist.add(Arrays.asList(items[i]));
		}
		
		sortpage(itemslist, sortParameter, sortOrder, itemsPerPage, pageNumber);
	}

}
