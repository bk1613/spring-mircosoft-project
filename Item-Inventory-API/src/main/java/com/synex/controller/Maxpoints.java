package com.synex.controller;

public class Maxpoints {

	public static void maxpoints(int[][] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i][0] == arr[i][1]) {
				count++;
			}
			else {
				break;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 1}, {2, 2}, {3, 3}, {4, 1}};
		
		maxpoints(arr);
	}

}
