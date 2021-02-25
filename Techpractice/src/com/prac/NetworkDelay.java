package com.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class NetworkDelay {

	public static int direct(int[][] times, int N, int K) {
		
		if(times.length == 0) {
			return -1;
		}
		
		int count = 0;
		int allnodes = 1;
		int prev = 0;
		for(int i = 0; i < times.length; i++) {
			for(int j = 1; j <= N; j++) {
				
				if(times[i][0] == K) {
					
					if(times[i][1] == j) {
						count += times[i][2];
						prev = times[i][1];
						allnodes++;
					}
//					else {
//						return -1;
//					}
					
				}else if(prev == times[i][0]) {
					if(times[i][1] == j) {
						allnodes++;
						continue;
					}
//					else {
//						return -1;
//					}
					
				}
				
			}
		}
		
		System.out.println(allnodes);
		if(allnodes < N) {
			return -1;
		}
		
		return count;
	}
	
	public int delayTime(int[][] times, int N, int K) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int[] e: times) {
			 List<int[]> nei = map.getOrDefault(e[0], new ArrayList<>());
	            nei.add(new int[]{e[1], e[2]});
	            map.put(e[0], nei);
		}
		
		
		Map<Integer, Integer> dist = new HashMap<>();
		pq.add(new int[] {K, 0});
		int max = 0;
		
		while(!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            
            if(dist.containsKey(node)) continue;
            dist.put(node, dis);
            max = Math.max(max, dis);
            if(map.containsKey(node))
            for(int[] nei : map.get(node)){
                
                int neiNode = nei[0]; int neiDist = nei[1];
                
                if(!dist.containsKey(neiNode)){
                    pq.add(new int[]{neiNode, neiDist + dis});
                }
            }
        }
		
		if(dist.size()!=N) {
			return -1;
		}
		
//		for(int i : dist.values()) {
//			max = Math.max(max, i);
//		}
		return max;
		
	}
	
	 Map<Integer, Integer> dist;
	    public int networkDelayTime(int[][] times, int N, int K) {
	        Map<Integer, List<int[]>> graph = new HashMap();
	        for (int[] edge: times) {
	            if (!graph.containsKey(edge[0]))
	                graph.put(edge[0], new ArrayList<int[]>());
	            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
	        }
	        for (int node: graph.keySet()) {
	            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
	        }
	        dist = new HashMap();
	        for (int node = 1; node <= N; ++node)
	            dist.put(node, Integer.MAX_VALUE);

	        dfs(graph, K, 0);
	        int ans = 0;
	        for (int cand: dist.values()) {
	            if (cand == Integer.MAX_VALUE) return -1;
	            ans = Math.max(ans, cand);
	        }
	        return ans;
	    }

	    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
	        if (elapsed >= dist.get(node)) return;
	        dist.put(node, elapsed);
	        if (graph.containsKey(node))
	            for (int[] info: graph.get(node))
	                dfs(graph, info[1], elapsed + info[0]);
	    }
	
	
	public static void main(String[] args) {
		
		int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
		int N = 4;
		int K = 2;
		
//		int[][] times = {{1,2,1}, {1, 2, 2}};
//		int N = 2;
//		int K = 1;
		System.out.println(new NetworkDelay().delayTime(times, N, K));
		//System.out.println(direct(times, N, K));

	}

}
