package com.synex.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ComputingClusterQuality {
	
	public static int min(int num, int num2) {
		if(num > num2) {
			return num2;
		}else{
			return num;
		}
	}
	
	public static int maxClusterQuality(int[] speed, int[] reliability, int maxMachines) {
		
		if(maxMachines >= speed.length) {
			return 0;
		}
		
		List<Integer> sumlist = new ArrayList<>();
		int count = 1;
		int min = reliability[0];
		int sum = 0;
		for(int i = 0; i < speed.length; i++) {
			sum += speed[i];
			int temp = sum;
			System.out.println("sum " + temp);
			for(int j = 0; j < speed.length; j++) {
				
				
//				System.out.println(speed[i] + " " +speed[j] + " " + temp);
				
				if(maxMachines == count) {
					sumlist.add(sum);
					count = 1;
					sum = temp;
				}
				
				if(speed[i] == speed[j]) {
					continue;
				}else {
					sum += speed[j];
				}
				count++;
			}
			
			sum = 0;
		}
		count = 1;
		
		List<Integer> minlist = new ArrayList<>();
		for(int i = 0; i < reliability.length; i++) {
			min = reliability[i];
			for(int j = 0; j < reliability.length; j++) {
				
				
				
				if(maxMachines == count) {
					minlist.add(min);
					count = 1;
					
				}
				if(speed[i] == speed[j]) {
					continue;
				}else {
					min = min(min, reliability[j]);
				}
				count++;
			}
		}
		
		
		int max = 0;
		for(int i = 0; i < sumlist.size(); i++) {
			int tot = sumlist.get(i) * minlist.get(i);
			
			if(tot > max) {
				max = tot;
			}
		}
		
		
		
		return max;
	}
	
	public static int solution(int n, int[] speed, int[] reliability, int maxMachines) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < reliability.length; i++) {
            map.put(reliability[i], i);
            queue.add(reliability[i]);
        }

        int min = Integer.MAX_VALUE;
        int totalSpeed = 0;

        int ans = 0;
        System.out.println(queue);
        System.out.println(map);
        int j = 0;
        while (j < maxMachines) {

            int rel = queue.poll();
            if (j == 0) {
                ans = rel * speed[map.get(rel)];
            }
           
            if (rel < min) {
                min = rel;
            }

            totalSpeed += speed[map.get(rel)];
            System.out.println(rel + " "+ totalSpeed + " " + ans + " "+min+" "+ map.get(rel));
            ans = Math.max(ans, totalSpeed * min);

            ++j;
        }

        return ans;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] speed = {4, 3, 15, 5, 6};
		int[] reliability = {7, 6, 1, 2, 8};
//		int[] speed = {11, 10, 7};
//		int[] reliability = {6, 4, 8};
//		int[] speed = {12, 112, 100, 13, 55};
//		int[] reliability = {31, 4,100, 55, 50};
		int maxMachines = 3;
	
		//System.out.println(maxClusterQuality(speed, reliability, maxMachines));
		System.out.println(solution(5, speed, reliability, maxMachines));
	}

}
