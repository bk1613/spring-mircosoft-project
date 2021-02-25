package com.prac;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GeneticMutation {
	
	public static int helper(String start, String end, String[] bank, String prevgene, int index) {
		
		if(start.equals(end)) {
			return 0;
		}
		
		int result = 0;
		int red = 0;
		
		
		System.out.println(start + " " + bank[index] + " " + prevgene);
		for(int i = 0; i < start.length(); i++) {
			if(start.charAt(i) != bank[index].charAt(i)) {
				
				result = helper(bank[index], end, bank, start, index+1) + 1;
				
			}
			if(!prevgene.isEmpty()) {
			
				if(prevgene.charAt(i) != start.charAt(i)) {
					result--;
				}
			
			}
		}

		
		return result;
	}
	
	public static int minMutation(String start, String end, String[] bank) {
		
		Queue<String> queue = new LinkedList<>();
        int steps = 0;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
 
        queue.offer(start);
        bankSet.remove(start);
 
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
 
        while (!queue.isEmpty()) {
            steps += 1;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                char[] curr = queue.poll().toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char ori = curr[i];
                    for (char c : gene) {
                        if (c == ori) {
                            continue;
                        }
 
                        curr[i] = c;
                        String mutated = new String(curr);
 
                        if (bankSet.contains(mutated)) {
                            if (mutated.equals(end)) {
                                return steps;
                            }
                             
                            queue.offer(mutated);
                            bankSet.remove(mutated);
                        }
                    }
 
                    curr[i] = ori;
                }
            }
        }
 
        return -1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String start = "AACCGGTT";
//		String end = "AACCGGTA";
//		String[] bank = {"AACCGGTA"};
		
//		String start = "AACCGGTT";
//		String end = "AAACGGTA";
//		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		
		String start = "AAAAACCC";
		String end = "AACCCCCC";
		String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
		
		System.out.println(minMutation(start, end, bank));
	}

}
