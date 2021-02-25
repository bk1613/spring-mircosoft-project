package com.prac;

public class BattleShips {

	public static int countBattleships(char[][] board) {
        
		int row = board.length;
		int column = board[0].length;
		
		int count = 0;
		
		char[] ships = new char[column];
		
		for(int i = 0; i < row; i++) {
			int countinvalid = 0;
			for(int j = 0; j < column; j++) {
				
				if(board[i][j] == 'X') {
					
					if(j > 0 && board[i][j-1] == 'X') {
						countinvalid++;
						continue;
					}
					
					if(j < column-1 && board[i][j+1] == 'X') {
						countinvalid++;
						continue;
					}
					
					if(ships[j] == board[i][j]) {
						continue;
					}
					
					ships[j] = board[i][j];
				}
			}
			
			if(countinvalid >= 1) {
				return -1;
			}
		}
		
		
		
		for(char a: ships) {
			if(a == 'X') {
				count++;
			}
		}
		
		return count;
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'X','.', '.', 'X'},
				{'X','X', '.', 'X'},
				{'.','X', '.', 'X'},};
		
		System.out.println(countBattleships(grid));
	}

}
