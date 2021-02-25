package com.synex.controller;

public class Sherlockstuck {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{0,1,1}, {0,1,1}, {0,1,1}};
//		int[][] matrix = {{0,1,0}, {0,1,0}, {0,1,0}};
		int[][] matrix = {{1,0,1}, {1,1,0}, {0,1,0}};
		
		int counter = 0;
		for(int i=matrix.length-1; i>=0; i--) {
			for(int j=matrix[i].length-1; j>=0; j--) {
				
				if(matrix[i][j] == 1) {
					System.out.println("(" + i + "," +j+")");
					counter++;
				}
				else {
					break;
				}
			}
		}
		System.out.println("counter: "+counter);
	}

}
