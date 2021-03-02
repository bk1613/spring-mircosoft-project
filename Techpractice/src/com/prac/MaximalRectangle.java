package com.prac;

public class MaximalRectangle {

	
	public static int findmaxrectangle(String[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		
		
		int area = 0;
		for(int i = 0; i < row; i++) {
			for(int j =0; j < col;j++) {
				int countrow = 0;
				int countcol = 0;
				if(grid[i][j].equals("1")) {
					
					for(int r = i; r < row; r++) {
						
						if(grid[r][j].equals("0")) {
							break;
						}
						countrow++;
						
						for(int c = j; c < row; c++) {
							if(grid[r][c].equals("0") || (i > 0 && grid[r-1][c].equals("0")) || (r < row-1 && grid[r+1][c].equals("0"))) {
								break;
							}else {
								if(countcol == 0 || c != j) {
									countcol++;
								}
								
							}
							
						}
					}
					
//					for(int r = i; r > -1; r--) {
//						if(grid[r][j].equals("0")) {
//							break;
//						}
//						countrow++;
//						for(int c = j; c > -1; c--) {
//						
//							if(grid[i][c].equals("0") || (i > 0 && grid[i-1][c].equals("0")) || (i < row-1 && grid[i+1][c].equals("0"))) {
//								break;
//							}
//							countcol++;
//						}
//					}
					System.out.println(countcol+" "+countrow);
					area = Math.max(area, countcol*countrow);

				}
				
				
			}
		}
		System.out.println(area);
		return area;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] arr = {
				{"1","0","1","0","0"},
				{"1","0","1","1","1"},
				{"1","1","1","1","1"},
				{"1","0","0","1","0"}
		};
		System.out.println(findmaxrectangle(arr));
	}

}
