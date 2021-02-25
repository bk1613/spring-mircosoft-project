package com.synex.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MinustesToTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inminutes = 1150;
		int hours = inminutes/60;
		int minutes = inminutes%60;
		System.out.println(hours + ":" + minutes +" am");
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("hh:mm a");
		LocalTime time = LocalTime.of(hours, minutes);
		System.out.println(time.format(pattern));
//		LocalTime time = LocalTime.parse(Integer.valueOf(minutes).toString(), Dat)
	}

}
