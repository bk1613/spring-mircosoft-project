package com.prac;

import java.util.ArrayList;
import java.util.List;

public class MaxProfitDeadline {

	public static void maxprofit(int[] task, int[] deadlines, int[] profit) {
		
		int maxdeadline = 0;
		for(int i = 0; i < deadlines.length; i++) {
			if(deadlines[i] > maxdeadline) {
				maxdeadline = deadlines[i];
			}
		}
		
		int[] maxpr= new int[maxdeadline];
		int[] assignedtasks = new int[maxdeadline];
		
		for(int i = 0; i < maxpr.length; i++) {
			for(int j = 0; j < deadlines.length; j++) {
				if(profit[j] > maxpr[i] && deadlines[j]-1 >= i) {
					
				}
			}
		}
		
		
		
		System.out.println(maxdeadline);
		
	}
	
	public static void main(String[] args) {
		int[] tasks = {1,2,3,4,5,6,7,8,9,10};
		int[] deadlines = {9, 2,5,7,4,2,5,7,4,3};
		int[] profits = {15, 2, 18,1, 25, 20,8, 10, 12,5};
		maxprofit(tasks, deadlines, profits);
	}

}
