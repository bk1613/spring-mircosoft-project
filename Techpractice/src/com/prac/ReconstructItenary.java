package com.prac;

import java.util.ArrayList;
import java.util.List;

public class ReconstructItenary {

	public static List<String> findItinerary(List<List<String>> tickets) {
		
		String temp = "JFK";
		int count = 0;
		List<String> orderticket = new ArrayList<>();
		String prev = "";
		String t = "";
		for(int i = 0; i < tickets.size(); i++) {
			count++;
			
			for(int j = 0; j < tickets.size(); j++) {
				if(orderticket.size() < tickets.size()) {
					if(prev == tickets.get(j).get(0)) {
						if(temp.compareTo(tickets.get(j).get(1)) < 0) {
							orderticket.add(temp);
							
						}else {
							orderticket.add(tickets.get(j).get(1));
							
						}
						orderticket.add(prev);
						prev = tickets.get(j).get(1);
						break;
					}
					
					if(tickets.get(j).get(0) == temp) {
						orderticket.add(tickets.get(j).get(0));
						
						if(temp.compareTo(prev) < 0) {
							t = prev;
						}else {
							t = tickets.get(j).get(1);
						}
						
						prev = temp;
						temp = tickets.get(j).get(1);	
					}
					
				}
				
				
				
			}
			
		}
		if(orderticket.size() < tickets.size()+1) {
			orderticket.add(t);
		}
		return orderticket;
    }
	
	/*
	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	LinkedList<String> result = new LinkedList<String>();
 
	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket[0], q);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
 
		dfs("JFK");
		return result;
	}
 
	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> listtickets = List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"));
//		List<List<String>> listtickets = new ArrayList();
//		listtickets.add(List.of("JFK","SFO"));
//		listtickets.add(List.of("JFK","ATL"));
//		listtickets.add(List.of("SFO","ATL"));
//		listtickets.add(List.of("ATL","JFK"));
//		listtickets.add(List.of("ATL","SFO"));
		
	
		System.out.println(listtickets);
		System.out.println(findItinerary(listtickets));

	}

}
