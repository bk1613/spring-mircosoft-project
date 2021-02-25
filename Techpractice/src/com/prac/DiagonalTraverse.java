package com.prac;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
	
	public static int[] findDiagonalOrder(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		int[] arr = new int[row*col];		
		
		int count = 0;
		
		boolean up = true;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(matrix[i][j] == 5) {
					
					
					System.out.println(matrix[i][j]);
					if(i >0 && i < row-1) {
						System.out.println("rows");
						System.out.println(matrix[i-1][j]);
						System.out.println(matrix[i+1][j]);
						System.out.println(matrix[i-1][j+1]);
						System.out.println(matrix[i+1][j-1]);
					}
					
					if(j > 0 && j < col-1) {
						System.out.println("cols");
						System.out.println(matrix[i][j-1]);
						System.out.println(matrix[i][j+1]);
						System.out.println(matrix[i-1][j-1]);
						System.out.println(matrix[i+1][j+1]);
					}
					
				}
				
			}
		}
		for(int i = 0; i < row; ) {
			for(int j = 0; j < col; ) {
				
				if(i >= row || j >= col) {
					break;
				}
				
				arr[count] = matrix[i][j];
				
				if(up) {
					if(j + 1 < col) {
						i--;
						j++;
						if(i < 0) {
							i = 0;
							up = !up;
						}
					}else {
						i++;
						up = !up;
					}
				}else {
					if(i + 1 < row) {
						i++;
						j--;
						if(j<0) {
							j=0;
							up = !up;
						}
					}else {
						j++;
						up = !up;
					}
				}
				
				
				count++;
			}
		}
		
		return arr;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; 
		
		for(int a: findDiagonalOrder(matrix)) {
			System.out.print(a + " ");
		}
	}

}
