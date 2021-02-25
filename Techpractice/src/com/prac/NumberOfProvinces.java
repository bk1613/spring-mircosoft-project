package com.prac;

public class NumberOfProvinces {

	
	
	public static int findCircleNum(int[][] isConnected) {
        
		
		boolean[] visited = new boolean[isConnected.length];
		
		int cnt = 0;
		
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == false){
                dfs(i, isConnected, visited);
                cnt++;
            }
		}
		return cnt;
    }
	
	public static void dfs(int v, int[][] mat, boolean[] visited){
        if(!visited[v]){
            visited[v] = true;
        }
        
        for(int i = 0; i < mat.length; i++){
            if(mat[v][i] == 1 && !visited[i]){
                dfs(i, mat, visited);
            }
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		
		
		System.out.println(findCircleNum(isConnected));
	}

}
