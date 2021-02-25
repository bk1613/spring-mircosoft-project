package com.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface OnlineAccount{
	double basePrice = 3.0;
	double regularMoviePrice = 2.5;
	double exclusiveMoviePrice = 5.5;
}

public class AccountComparison implements OnlineAccount, Comparable<AccountComparison>{

	Integer noOfRegularMovies;
	Integer noOfExeclusiveMovies;
	String ownername;
	
	
	
	public AccountComparison(Integer noOfRegularMovies, Integer noOfExeclusiveMovies, String ownername) {
		super();
		this.noOfRegularMovies = noOfRegularMovies;
		this.noOfExeclusiveMovies = noOfExeclusiveMovies;
		this.ownername = ownername;
	}

	

	public static void main(String[] args) {
		
		List<AccountComparison> list = new ArrayList<>();
		list.add(new AccountComparison(12, 6, "Frank"));
		list.add(new AccountComparison(7, 19, "David"));
		list.add(new AccountComparison(14, 4, "Karen"));
		
		for(int i = 0; i < list.size(); i++) {
			list.get(i).monthlyCost();
		}
		
		Collections.sort(list);
		
		int n = list.size() - 1;
		
		System.out.println(list.get(n));
	}
	
	public double monthlyCost() {
		return basePrice + (noOfRegularMovies*regularMoviePrice) + (noOfExeclusiveMovies*exclusiveMoviePrice);
	}

	@Override
	public String toString() {
		return "Owner is " + ownername + " and monthly cost is " + this.monthlyCost() + " USD.";
	}

	@Override
	public int compareTo(AccountComparison o) {
		// TODO Auto-generated method stub
		return (int)(this.monthlyCost() - o.monthlyCost());
	}

}
