package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

//	public static int brickwall(int[][] arr) {
//		int count = 0;
//		for(int i = 0; i < arr[0].length; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				if(i+1 < arr[j].length) {
//					
//				}else {
//					count++;
//				}
//			}
//		}
//		
//		System.out.println(count);
//		return 0;
//	}
	
	public static int brickwall(int[][] wall) {
		
//		if(wall.length == 0) {
//			return 0;
//		}
//		
//		Map<Integer, Integer> map = new HashMap<>();
//		
//		int count = 0;
//		for(int i = 0; i < wall.length; i++) {
//			int length = 0;
//			for(int j = 0; j < wall[i].length-1; j++) {
//				length += wall[i][j];
//				
//				map.put(length, map.getOrDefault(length, 0)+1);
//				count = Math.max(count, map.get(length));
//			}
//		}
//		
//		System.out.println(count);
//		return 0;
		
		List<List<Integer>> sums = new ArrayList<>();

        for (int i = 0; i < wall.length; i++) {
            sums.add(new ArrayList<>());
            int sum = 0;
            for (int j = 0; j < wall[i].length; j++) {
                sum += wall[i][j];
                sums.get(i).add(sum);
            }
        }
        System.out.println(sums);
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : sums) {
            for (int n : list) {
            	//System.out.println(map.getOrDefault(n, 0)+1);
                map.put(n, map.getOrDefault(n, 0)+1);
            }
        }
        System.out.println(map);
        int max = 0;
        int prev = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            prev = max;
            System.out.println(prev);
            max = Math.max(max, entry.getValue());
        }

        return wall.length - prev;
		
	}
	
	
	public static void main(String[] args) {
		
		int[][] array = {{1, 2, 2, 1},
						 {3, 1, 2},
						 {1, 3, 2},
						 {2, 4},
						 {3, 1, 2},
						 {1, 3, 1, 1}};
		
		System.out.println(brickwall(array));
	}
	
	
	
	
	

}


