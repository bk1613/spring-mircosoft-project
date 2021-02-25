package com.prac;

public class BombEnemy {

	public static void solve(char[][] board) {
		
		int max = 0;
        for(int i = 0; i < board.length; i++) {
        	int count = 0;
        	for(int j = 0; j < board[i].length; j++) {
            	
            	if(board[i][j] == '0') {
            		
            		if(i > 0 && board[i-1][j] == 'E') {
            			
            			count++;
            		}
            		
            		if(i < board.length-1 && board[i+1][j] == 'E') {
            			
            			count++;
            		}
            		
            		if(j > 0 && board[i][j-1] == 'E') {
            			
            			count++;
            		}
            		
            		if(j < board[i].length-1 && board[i][j+1] == 'E') {
            			
            			count++;
            		}
            	}
            
            	max = Math.max(max, count);
            	count = 0;
            }

        }
        System.out.println(max);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		char[][] grid = {{'0','E', '0', '0'},
//						{'E','0', 'W', '0'},
//						{'0','E', '0', '0'},};
		
		char[][] grid = {{'0','E', '0', '0'},
						{'E','E', 'W', 'E'},
						{'0','E', '0', '0'},};
		solve(grid);
		//Select * from Student Order By Score DESC LIMIT 1 OFFSET 212;
	}

}
