package com.synex.controller;

public class HouseRobberII {

	public int checkAdjacent(int[] arr) {

		int pre_rob = 0, pre_miss = 0;
        for(int i = 0; i < arr.length; i++){
            int temp = pre_rob;
            pre_rob = pre_miss + arr[i];
            pre_miss = Math.max(temp,pre_miss);

        }
        return Math.max(pre_rob, pre_miss);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {2, 3, 2};
		int[] arr = {1, 2, 3, 1};
		
		HouseRobberII hr = new HouseRobberII();
		
		System.out.println(hr.checkAdjacent(arr));
	}

}
