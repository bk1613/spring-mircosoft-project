package com.prac;

import java.util.Stack;

public class LargestRectangle {

//	public static int findLargeRectangle(int[] height) {
//		
//		int max = 0;
//		
//		for(int i = 0; i < height.length; i++) {
//			int count = 1;
//			
//			for(int j = i; j < height.length; j++) {
//				
//				int result =0;
//				if(i == j) {
//					continue;
//				}
//				count++;
//				if(height[i] >= height[j]){
//					
//					result = height[j]*count;
//					
//				}
//				System.out.println(result + " " + height[i] + " "+ height[j] + " " +count);
//				max = Math.max(max, result);
//			}
//			
//		}
//		
////		System.out.println(max);
//		return max;
//	}
	
	
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {2, 1, 5, 6, 2, 3};
		
		System.out.println(largestRectangleArea(heights));
	}

}
