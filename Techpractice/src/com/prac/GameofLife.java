package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GameofLife {

	
	public static void gameOfLife(int[][] board) {
		
		
		
		Map<List<Integer>, Integer> map = new HashMap<>();
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		int liveneighbors = 0;
        		List<Integer> list = new ArrayList<>();
        		
        		if(i > 0) {
        			if(board[i-1][j] == 1) {
        				liveneighbors++;
        			}
        			if(j > 0 && board[i-1][j-1] == 1) {
        				liveneighbors++;
        			}
        			if(j < col-1 && board[i-1][j+1] == 1) {
        				liveneighbors++;
        			}
        			
        		}
        	
        		if(i < row-1) {
        			if(board[i+1][j] == 1) {
        				liveneighbors++;
        			}
        			if(j > 0 && board[i+1][j-1] == 1) {
        				liveneighbors++;
        			}
        			if(j < col-1 && board[i+1][j+1] == 1) {
        				liveneighbors++;
        			}
        		}
        		

        		if(j > 0 && board[i][j-1] == 1) {
        			liveneighbors++;
        		}
        		
        		if(j < col-1 && board[i][j+1] == 1) {
        			liveneighbors++;
        		
        		}
        		
        		
        		if(board[i][j] == 1) {
        			if(liveneighbors < 2 || liveneighbors > 3) {
        				list.add(i);
        				list.add(j);
        				map.put(list, 0);
        			}
        		}else {
        			if(liveneighbors == 3) {
        				list.add(i);
        				list.add(j);
        				map.put(list, 1);
        			}
        		}
        		
        		
        	}
        }
        
        for(List<Integer> l: map.keySet()) {
        	board[l.get(0)][l.get(1)] = map.get(l);
        }
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
		};
//		int[][] board = {
//				{1,1},
//				{1,0},
//				
//		};
		
		gameOfLife(board);
		 int row = board.length;
	        int col = board[0].length;
	        
	        for(int i = 0; i < row; i++) {
	        	for(int j = 0; j < col; j++) {
	        		System.out.print(board[i][j] + " ");
	        	}
	        	System.out.println();
	        }
		
	}

}
