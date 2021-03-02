package com.prac;

public class GasStation {

	public static int helper(int[] gas, int[] cost, int start, int nextstation, int st, int tank) {

		if(start == nextstation) {
			return tank;
		}
		
		if(nextstation == gas.length) {
			nextstation = 0;
			
		}
		if(st == gas.length) {
			
			st = 0;
		}
		
		System.out.println(tank+ " - "+ cost[st] + " + "+ gas[nextstation] +" = " + ((tank - cost[st]) + gas[nextstation]));
		
		
		
		tank = helper(gas, cost, start, nextstation+1, st+1, tank - cost[st] + gas[nextstation]);
		
		return tank;
		
	}
	
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 2;
		int tank = 0 + gas[start]; 
		int nexstation = start+1;
		int st= start;
		int result = helper(gas, cost, start, nexstation, st, tank);
		
		if(gas[start] > result) {
			return -1;
		}else {
			return start;
		}
		 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] gas = {1, 2 ,3 ,4, 5};
//		int[] cost = {3, 4, 5, 1, 2};
		int[] gas = {2 ,3 ,4};
		int[] cost = {3, 4, 3};
		
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
