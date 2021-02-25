package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriticalConnection {

//	public static void connectNeywork(int n, int[][] connections) {
//		
//		int[][] network = new int[n][n];
//	
//		List<Integer> deadnodes = new ArrayList<>();
//		
//		for(int i = 0; i < connections.length; i++) {
//			network[connections[i][0]][connections[i][1]] = 1;
//			
//		}
//		
//		for(int i = 0; i < network.length; i++) {
//			boolean isDeadNode = Arrays.stream(network[i]).allMatch(j->j==0);
//			if(isDeadNode) {
//				deadnodes.add(i);
//			}
//		}
//		
//		List<List<Integer>> criticalConditions = new ArrayList<>();
//		
//		for(Integer a: deadnodes) {
//			int route = 0;
//			int fromNode=-1;
//			for(int i = 0; i < network.length; i++) {
//				if(network[i][a]==1) {
//					if(fromNode == -1) {
//						fromNode=i;
//						route++;
//					}
//				}
//			}
//		}
//		
//		
//	}
	int T = 1;
	public int dfs(List<List<Integer>> graph, int[] timestamp, int v, int parent, List<List<Integer>> criticalConns) {
		  if (timestamp[v] != 0) { // if a node is visited, its timestamp won't be 0
			    return timestamp[v];
			  }
			  timestamp[v] = T++; // set the node timestamp
			  
			  // find the node that can be reached with the smallest timestamp
			  int minTimestamp = Integer.MAX_VALUE;
			  for (int neighbor : graph.get(v)) {
			    if (neighbor == parent) continue; // no need to check the parent
			    int neighborTimestamp = dfs(graph, timestamp, neighbor, v, criticalConns);
			    minTimestamp = Math.min(minTimestamp, neighborTimestamp);
			  }
			  
			  // minTimestamp < timestamp[v] --> a cycle
			  if (minTimestamp >= timestamp[v]) { // no cycle
			    if (parent >= 0) criticalConns.add(Arrays.asList(parent, v));
			  }
			  return Math.min(timestamp[v], minTimestamp);
	}
	
	public List<List<Integer>> criticalConnection(int n, int[][] connections){
		
		 if (n == 0 || connections.length == 0) {
			    return new ArrayList<>();
			  }
			  // Use a timestamp, check the smallest timestamp that can reach from the node
			  // construct the graph first
			  List<List<Integer>> graph = new ArrayList<>();
			  for (int i = 0; i < n; ++i) {
			    graph.add(new ArrayList<Integer>());
			  }
			  for (int[] conn : connections) {
			    graph.get(conn[0]).add(conn[1]);
			    graph.get(conn[1]).add(conn[0]);
			  }
			  
			  int [] timestamp = new int[n];
			  // for each node, we need to run DFS for it, and return the smallest timestamp in all of its children except its parent
			  List<List<Integer>> criticalConns = new ArrayList<>();
			  dfs(graph, timestamp, 0, -1, criticalConns); // -1 is the parent
			  return criticalConns;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] connections = {{0,1},{1,2},{2,0},{1,3}};
		
		System.out.println(new CriticalConnection().criticalConnection(n, connections));
		//connectNeywork(n, connections);
	}

}
