package com.prac;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CourseSchedule {

//	public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        
//		Map<Integer, Integer> map = new HashMap<>();
//		int count = 1;
//		boolean t = false;
//		for(int i = 0; i < prerequisites.length; i++) {
//			map.put(prerequisites[i][0], prerequisites[i][1]);
//			
//			for(int a: map.keySet()) {
//				
//				if(a == prerequisites[i][1] && map.get(a) == prerequisites[i][0]) {
//					return t;
//				}
//				
//			}
//			count++;
//		}
//		
//		if(count == numCourses) {
//			t = true;
//		}
//		
//		return t;
//    }
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int len = prerequisites.length;
	 
	    if(numCourses == 0 || len == 0){
	        return true;
	    }
	 
	    // counter for number of prerequisites
	    int[] pCounter = new int[numCourses];
	    for(int i=0; i<len; i++){
	        pCounter[prerequisites[i][0]]++;
	    }
	 
	    //store courses that have no prerequisites
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    for(int i=0; i<numCourses; i++){
	        if(pCounter[i]==0){
	            queue.add(i);
	        }
	    }
	 
	    // number of courses that have no prerequisites
	    int numNoPre = queue.size();
	 
	    while(!queue.isEmpty()){
	        int top = queue.remove();
	        for(int i=0; i<len; i++){
	            // if a course's prerequisite can be satisfied by a course in queue
	            if(prerequisites[i][1]==top){
	                pCounter[prerequisites[i][0]]--;
	                if(pCounter[prerequisites[i][0]]==0){
	                    numNoPre++;
	                    queue.add(prerequisites[i][0]);
	                }
	            }
	        }
	    }
	 
	    return numNoPre == numCourses;
	}

	public static void main(String[] args) {

		int[][] courses = {{1,0}, {0, 1}};
		
		int numCourse = 2;
		
		System.out.println(canFinish(numCourse, courses));
	}

}
