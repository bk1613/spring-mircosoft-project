package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ReorderRoutes {

//	public static int dfs(List<List<Integer>> list, boolean[] visted, int root) {
//		int cnt = 0;
//		visted[root] = true;
//		
//		for(int to: list.get(root))  {
//			if(!visted[Math.abs(to)]) {
//				cnt+=dfs(list, visted, Math.abs(to)) + ((to>0)?1:0);
//			}
//		}
//		return cnt;
//	}
	
	public static int dfs(List<List<Integer>> list, boolean[] visited,Set<String> paths, int change) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int v=queue.poll();
            if(!visited[v]){
                List<Integer> childs=list.get(v);
                for(int child:childs){
                    if(!visited[child]){
                        String str= v +"#"+ child;
                        if(!paths.contains(str))
                            change++;
                        queue.add(child);
                    }

                }
                visited[v]=true;
            }
        }
        return change;
    }
	public static int reorderroutes(int n, int[][] connections) {
		
		if (n == 0 || connections.length == 0) {
		    return 0;
		  }
		Set<String> pathsOrder=new HashSet<>();
        for(int[] p:connections){
            int a=p[0];
            int b=p[1];
            pathsOrder.add(a +"#"+ b);
        }
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int[] c : connections) {
			list.get(c[0]).add(c[1]);
			list.get(c[1]).add(c[0]);
			
			System.out.println(list.get(c[0]) + " "+list.get(c[1]));
		}
		
		System.out.println(list);
		System.out.println(dfs(list, new boolean[n], pathsOrder, 0));
		return 0;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		reorderroutes(n, connections);
	}
	
}
