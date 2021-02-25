package com.synex.controller;

public class CountOccurance {

	public static int findIndexOfAnOcurrance(int start, int end, int[] arr, int target) {
		if(start > end)return -1;
		int mid = start + (end - start)/2;
		if(arr[mid] == target)return mid;
		else if(arr[mid] < target)return findIndexOfAnOcurrance(mid+1, end, arr, target);
		else return findIndexOfAnOcurrance(start, mid-1, arr, target);
	}
	
	public static int countOcurrences(int[] arr, int target) {
		int occurringIndex = findIndexOfAnOcurrance(0, arr.length-1, arr, target);		
		if(occurringIndex != -1) {
			int occurrences = 1;
			//going from left to right starting at mid
			int index = occurringIndex + 1;
			while(index < arr.length && arr[index] == target) {
				index++;
				occurrences++;
			}

			//going from right to left starting at mid
			index = occurringIndex - 1;
			while(index >= 0 && arr[index] == target) {
				index--;
				occurrences++;
			}
			return occurrences;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
		int target = 5;
		System.out.println("Element " + target + " occurs " + countOcurrences(A, target) + " times");
	}

}
