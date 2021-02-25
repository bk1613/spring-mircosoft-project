package com.synex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class EmployeeFreeTime {

	public class Interval{
		int start;
		int end;
		Interval(){
			start = 0;
			end = 0;
		}
		Interval(int s, int e){
			start = s;
			end = e;
		}
		@Override
		public String toString() {
			return "["+start + ", " + end +"]";
		}
		
		
		
	}
	
	
	public static void checkFreeTime(int[][][] sche) {
		
		List<Interval> res = new ArrayList<>();
		List<Interval> list = new ArrayList<>();
		
		for(int i = 0; i < sche.length; i++) {
			for(int j = 0; j < sche[i].length; j++) {
				Interval in = new EmployeeFreeTime().new Interval(sche[i][j][0], sche[i][j][1]);
				list.add(in);
			}
		}
		
		//System.out.println(res);
		Comparator<Interval> c = (i1, i2) -> i1.start == i2.start? i1.end - i2.end : i1.start - i2.start;
		
		list.sort(c);
		Queue<Integer> endtime = new PriorityQueue<>(Collections.reverseOrder());
		endtime.add(list.get(0).end);
		
		for(int i = 0; i< list.size(); i++) {
			System.out.println("size: " + endtime.size() + ",  "+ endtime.peek() + " " +list.get(i).start + " to " + list.get(i).end);
			if(endtime.size() > 0 && endtime.peek() < list.get(i).start) {
				res.add(new EmployeeFreeTime().new Interval(endtime.peek(), list.get(i).start));
			}
			endtime.add(list.get(i).end);
		}
		
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][][] schedule = { {{1,2}, {5,6}}, {{1,3}}, {{4,10}} };
		int[][][] schedule = { {{1,3}, {6,7}}, {{2,4}}, {{2,5}, {9, 12}} };
		checkFreeTime(schedule);
		
	}

}
