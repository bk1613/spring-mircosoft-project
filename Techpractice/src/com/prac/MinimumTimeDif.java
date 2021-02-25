package com.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumTimeDif {
	
	
	public static int findMinDifference(List<String> timePoints) {
//        if(timePoints.size() == 2) {
//        	int m1 = (int)parseTimeToMinutes(timePoints.get(0));
//        	int m2 = (int)parseTimeToMinutes(timePoints.get(1));
//        	if(m1 > m2) {
//        		return m1 - m2;
//        	}else {
//        		return m2 - m1;
//        	}
//        	
//        }else {
//        	int result = 0;
//        	int min = (int)parseTimeToMinutes(timePoints.get(0));
//        	for(int i = 1; i < timePoints.size(); i++) {
//        		int min2 = (int)parseTimeToMinutes(timePoints.get(i));
//        		
//        		result += min - min2;
//        		min = min2;
// 
//        	}
//        	return result;
//        }
		List<Integer> list=timePoints.stream().map(s->s.split(":")).map(
	          p->60*Integer.parseInt(p[0])+Integer.parseInt(p[1])).sorted((a,b)->b-a).collect(Collectors.toList());        
	        
	    int min=IntStream.range(0,list.size()-1).map(i->list.get(i)-list.get(i+1)).min().getAsInt();
	    return Math.min(min,60*24-(list.get(0)-list.get(list.size()-1)));
		
    }
	
	public static double parseTimeToMinutes(String hourFormat) {
		
		double minutes = 0;
		String[] split = hourFormat.split(":");
		
		try {
			if(Double.parseDouble(split[0]) == 0 && Double.parseDouble(split[1]) == 0) {
				split[0] = "24";
			}
			minutes += Double.parseDouble(split[0])*60;
			minutes += Double.parseDouble(split[1]);
			return minutes;
		
		} catch (Exception e) {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = List.of("23:59", "00:00");
		System.out.println(parseTimeToMinutes("23:59"));
		
		System.out.println(findMinDifference(list));
	}

}
