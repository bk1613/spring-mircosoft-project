package com.prac;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

//	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        
//		List<List<Integer>> cordslist = new ArrayList<>();
//		
//		int i = 0;
//		int j = 0;
//		
//		for(i = 0; i < matrix.length; i++) {
//			
//			
//			for(j = 0; j < matrix[i].length; j++) {
//				List<Integer> cords = new ArrayList<>();
//				int count = 0;	
//				
//				if(i > 0 && matrix[i-1][j] > matrix[i][j]) {
//					continue;
//        			
//        		}
//        		
//        		if(i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]) {
//        			
//        			continue;
//        		}
//        		
//        		if(j > 0 && matrix[i][j-1] >  matrix[i][j]) {
//        			continue;
//        			
//        		}
//        		
//        		if(j < matrix[i].length-1 && matrix[i][j+1] >  matrix[i][j]) {
//        			continue;
//        		}
//        		
//        		//System.out.print(count + " ");
//        		
////        		if(i == 0 && j == matrix[i].length-1) {
////        			cords.add(i);
////    				cords.add(j);
////    				cordslist.add(cords);
////        		}else {
////        			cords.add(i);
////    				cords.add(j);
////    				cordslist.add(cords);
////        		}
//        		
//        		
//        		
//			}
//			System.out.println();
//			
//		}
//		
//		System.out.println(cordslist);
//		return cordslist;
//    }
	
	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int pacific[][] = new int[m][n];
        int atlantic[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    if(pacific[i][j] == 0) {
                        dfs(i, j, pacific, matrix);
                    }
                }

                if(i == m-1 || j == n-1) {
                    if(atlantic[i][j] == 0) {
                        dfs(i, j, atlantic, matrix);
                    }
                }
            }
        }


        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(atlantic[i][j] == 1 && pacific[i][j] == 1) {
                    ans.add(List.of(i,j));
                }
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, int[][] pacific, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n) return;
        if(pacific[i][j] == 1) return;
        pacific[i][j] = 1;

        if(i < m - 1 && matrix[i][j] <= matrix[i+1][j]) dfs(i+1, j, pacific, matrix);
        if(i > 0 && matrix[i][j] <= matrix[i-1][j]) dfs(i-1, j, pacific, matrix);

        if(j < n - 1 && matrix[i][j] <= matrix[i][j+1]) dfs(i, j+1, pacific, matrix);
        if(j > 0 && matrix[i][j] <= matrix[i][j-1]) dfs(i, j-1, pacific, matrix);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1, 2, 2, 3, 5},	
				{3, 2, 3, 4, 4},	
				{2, 4, 5, 3, 1},	
				{6, 7, 1, 4, 5},	
				{5, 1, 1, 2, 4},	
		};
		
		System.out.println(pacificAtlantic(matrix));
	}

}
