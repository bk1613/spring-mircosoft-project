package com.prac;

public class MaximalSquare {

//	public static int maximalSquare(char[][] matrix) {
//        
//		int max = 0;
//		int countrow = 0;
//		int countcol = 0;
//		for(int i = 0; i < matrix.length; i++) {
//			for(int j = 0; j < matrix.length; j++) {
//				countrow = 0;
//				countcol = 0;
//				if(matrix[i][j] == '1') {
//					
//					for(int k = i+1; k < matrix.length; k++) {
//						if(matrix[k][j] == '1') {
//							countrow++;
//						
//							for(int l = j+1; l < matrix[k].length; l++) {
//								
//								if(matrix[i][l] == '1') {
//									countcol++;
//									
//								}else {
//									break;
//								}
//								
//							}
//						}else {
//							break;
//						}
//						
//						
//					}
//
//				}
//				
//			}
//			
//			if(countrow == countcol) {
//				max = Math.max(countrow, countcol);
//			}
//			
//		}
//		System.out.println(max);
//		return max;
//    }
	
	public static int maximalSquare(char[][] matrix) {
	    if(matrix==null||matrix.length==0){
	        return 0;
	    }
	 
	    int result=0;
	    int[][] dp = new int[matrix.length][matrix[0].length];
	 
	    for(int i=0; i<matrix.length; i++){
	        dp[i][0]=matrix[i][0]-'0';
	        result=Math.max(result, dp[i][0]);
	    }
	 
	    for(int j=0; j<matrix[0].length; j++){
	        dp[0][j]=matrix[0][j]-'0';
	        result=Math.max(result, dp[0][j]);
	    }
	 
	    for(int i=1; i<matrix.length; i++){
	        for(int j=1; j<matrix[0].length; j++){
	            if(matrix[i][j]=='1'){
	                int min = Math.min(dp[i-1][j], dp[i][j-1]);
	                min = Math.min(min, dp[i-1][j-1]);
	                dp[i][j]=min+1;
	 
	                result = Math.max(result, min+1);
	            }else{
	                dp[i][j]=0;
	            }    
	        }
	    }
	 
	    return result*result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
						};
		maximalSquare(matrix);
	}

}
