package com.synex.controller;

public class ProductArray {

	
	/*
	 Product of Array Except Self
	Given an array nums of n integers where n >1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
	Example:
	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
	Note: Please solve it without division and in O(n).
	Follow up:
	Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

	 */
	public static void productself(int[] arr) {
		
		int[] pro = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			int temp = 1;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					continue;
				}else {
					temp *= arr[j];
				}
				
			}
			pro[i] = temp;
		}
		
		for(int a: pro) {
			System.out.print(a + " ");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4};
		productself(arr);
	}

}
