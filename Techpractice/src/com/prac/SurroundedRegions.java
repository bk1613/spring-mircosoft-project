package com.prac;

public class SurroundedRegions {

	public static void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
        	int count = 0;
        	for(int j = 0; j < board[i].length; j++) {
            	
            	if(board[i][j] == 'O') {
            		System.out.println(i + " "+ j);
            		
            		if(i > 0 && board[i-1][j] == 'X') {
            			System.out.println("top");
            			count++;
            			System.out.println(count);
            		}
            		
            		if(i < board.length-1) {
            			System.out.println("bottom");
            			for(int k = i+1; k < board.length; k++) {
            				if(board[k][j] == 'X') {
            					count++;
            					break;
            				}else {
            					continue;
            				}
            			}
            			System.out.println(count);
            		}
            		
            		if(j > 0) {
            			System.out.println("left");
            			for(int k = 0; k < j; k++) {
            				System.out.println(board[i][k]);
            				if(board[i][k] == 'X') {
            					count++;
            					break;
            				}else {
            					continue;
            				}
            			}
            			System.out.println(count);
            		}
            		
            		if(j < board[i].length-1) {
            			
            			System.out.println("right");
            			for(int k = j+1; k < board[i].length; k++) {
            				if(board[i][k] == 'X') {
            					count++;
            					break;
            				}else {
            					continue;
            				}
            				
            			}
            			System.out.println(count);
            		}
//            		System.out.println(count);
            		System.out.println();
            	}
            	
            	if(count == 4) {
            		board[i][j] = 'X';
            	}
            	count = 0;
            }
        	
        }
        
        System.out.println();
        for(int i = 0; i < board.length; i++) {
        	
        	for(int j = 0; j < board[i].length; j++) {
            	System.out.print(board[i][j] + " ");
            	
            }
        	System.out.println();
        }
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		solve(board);
	}

}
