package com.synex.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Employee{
	abstract void setSalary(int salary);
	abstract int getSalary();
	abstract void setGrade(String grade);
	abstract String getGrade();
	void label() {
		System.out.println("Employee's data");
	}
}

class Engineer extends Employee{

	private int salary;
	
	private String grade;

	@Override
	void setSalary(int salary) {
		// TODO Auto-generated method stub
		this.salary = salary;
	}

	@Override
	int getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}

	@Override
	void setGrade(String grade) {
		// TODO Auto-generated method stub
		this.grade = grade;
	}

	@Override
	String getGrade() {
		// TODO Auto-generated method stub
		return grade;
	}
	
}

class Manager extends Employee{

	private int salary;
	
	private String grade;

	@Override
	void setSalary(int salary) {
		// TODO Auto-generated method stub
		this.salary = salary;
	}

	@Override
	int getSalary() {
		// TODO Auto-generated method stub
		return salary;
	}

	@Override
	void setGrade(String grade) {
		// TODO Auto-generated method stub
		this.grade = grade;
	}

	@Override
	String getGrade() {
		// TODO Auto-generated method stub
		return grade;
	}
}

public class EmployeeProfile {
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
		String in = bufferedReader.readLine();
		int num = Integer.parseInt(in);
		
		String[] arr = new String[num];
		
		Engineer en = new Engineer();
		Manager ma = new Manager();
		
		
		for(int i = 0; i < num; i++) {
			String Emp = bufferedReader.readLine();
			arr[i] = Emp;
		}
		
		for(String e: arr) {
			en.label();
			String[] earr = e.split(" ");
//			System.out.println(earr[0]);
			if(earr[0].equals("ENGINEER")) {
				
				en.setGrade(earr[1]);
				en.setSalary(Integer.parseInt(earr[2]));
				
				System.out.println("GRADE: " + en.getGrade());
				System.out.println("SALARY: " + en.getSalary());
			}else if(earr[0].equals("MANAGER")) {
				
				
				ma.setGrade(earr[1]);
				ma.setSalary(Integer.parseInt(earr[2]));
				
				System.out.println("GRADE: " + ma.getGrade());
				System.out.println("SALARY: " + ma.getSalary());
			}
			
		}
	}

}
