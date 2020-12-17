package com.synex.controller;

import java.util.HashMap;
import java.util.List;

public class Cashier {
	
	int n;
	
	int discount;
	
	HashMap<Integer, Integer> order = new HashMap<>();

	public Cashier(int n, int discount, List<Integer> l1, List<Integer> l2) {
		
		for(int i=0; i< l2.size();i++) {
			
			order.put(l1.get(i), l2.get(i));
		}
		this.n = n;
		this.discount = discount;
	}
	int curr = 0;
	public double getBill(int[] l1, int[] l2) {
		
		curr++;
		
		boolean flag = curr == n;
		
		if(curr == n) {
			curr = 0;
		}
		
		double rst = 0;
		for(int i = 0; i < l1.length; i++) {
			int x = l1[i];
			double cost = order.get(x);
			double y = l2[i];
			rst += (cost * y);
		}
		
		if(flag) {
			rst = rst - (rst*discount)/100;
		}
		return rst;
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cashier cashier = new Cashier(3, 50, List.of(1,2,3,4,5,6,7), List.of(100,200,300,400,300,200,100));
		int[] a = {1,2};
		int[] b = {1,2};
		
		System.out.println(cashier.getBill(a,b));
		
		a = new int[]{3,7};
		b = new int[]{10,10};
		
		System.out.println(cashier.getBill(a,b));
		
		a = new int[]{1,2,3,4,5,6,7};
		b = new int[]{1,1,1,1,1,1,1};
		
		System.out.println(cashier.getBill(a,b));
	}

}
