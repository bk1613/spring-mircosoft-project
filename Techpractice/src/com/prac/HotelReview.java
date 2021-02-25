package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
A Trie is a special data structure used to store strings that can be visualized like a graph. It consists of nodes and edges. Each node consists of at max 26 
children and edges connect each parent node to its children. These 26 pointers are nothing but pointers for each of the 26 letters of the English alphabet 
A separate edge is maintained for every edge.
 */

class Trie{
	
	Trie[] children;
	boolean isEnd;
	
	public Trie() {
		children = new Trie[26];
		isEnd = false;
	}
	
	public void insert(String word) {
		
		Trie node = this;
		for(int i =0; i < word.length(); i++) {
			if(node.children[word.charAt(i)-'a'] == null) {
				node.children[word.charAt(i)-'a'] = new Trie();
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		node.isEnd = true;
	}
	
	public boolean search(String word) {
		Trie node = this;
		
		for(int i = 0; i < word.length(); i++) {
			if(node.children[word.charAt(i)-'a']==null) {
				return false;
			}
			node = node.children[word.charAt(i)-'a'];
		}
		return node.isEnd;
	}
	
}

public class HotelReview {
	
	public static List<Integer> sortGoodReviewDescendingorder(String[] B, Trie trie){
		List<Integer> list = new ArrayList<>();
		if(B.length == 0) {
			return list;
		}
		
		int[][] arr = new int[B.length][2];
		int count = 0;
		for(int i = 0; i < B.length; i++) {
			count = 0;
			String[] words = B[i].split("_");
			for(int j = 0; j < words.length; j++) {
				if(trie.search(words[j])) {
					count++;
				}
			}
			arr[i][0] = i;
			arr[i][1] = count;
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] arrA, int[] arrB) {
				if(arrA[1] == arrB[1]){
					
					return 0;
				}
				
				
				return arrB[1] - arrA[1];
			}
			
		});
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " arr[i][1] " + arr[i][1]);
			list.add(arr[i][0]);
		}
		return list;
	}
	
	public static void main(String[] args) {
		String A = "cool_ice_wifi";
		String[] B = {"water_is_cool", "cold_ice_drink", "cool_wifi_speed"};
		
		String[] str = A.split("_");
		Trie trie = new Trie();
		for(int i = 0; i < str.length; i++) {
			trie.insert(str[i]);
		}
		
		List<Integer> resultList = sortGoodReviewDescendingorder(B, trie);
		for(Integer val: resultList) {
			System.out.println(val);
		}
	}
}
