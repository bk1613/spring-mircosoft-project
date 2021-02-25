package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSort {

	public static int[]  subsort(int[] arr, int minlength, int startsort) {
		
		int[] sortedarr = new int[minlength];
		int[] newarr = new int[arr.length];
		int temp = startsort;
		int count = 0;
		for(int i = 0; i < arr.length; i++) {

			if(i == temp && count < minlength) {
				sortedarr[count] = arr[i];
				
				count++;
				temp++;
			}
			
		}
		
		Arrays.sort(sortedarr);
		
		count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i == startsort && count < minlength) {
				newarr[i] = sortedarr[count];
				count++;
				startsort++;
			}else {
				newarr[i] = arr[i];
			}
		}
		
		for(int a: newarr) {
			System.out.print(a + " ");
		}
		
		return newarr;
	}
	
	public static int[]  subsort2(int[] arr, int minlength, int startsort) {
		List<Integer> sortedarr1 = new ArrayList<>();
		
		int[] newarr = new int[arr.length];
		int temp = startsort;
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {

			if(i == temp && count < minlength) {
				sortedarr1.add(arr[i]);
				
				if(sortedarr1.size() == minlength) {
					int j = 0;
					Collections.sort(sortedarr1);
					for(int a = startsort; a <= i; a++) {
						newarr[a] = sortedarr1.get(j);
						j++;
					}
				}
				count++;
				temp++;
			}else {
				newarr[i] = arr[i];
			}
		}
		
		for(int i = 0; i < newarr.length; i++) {
			System.out.print(newarr[i] + " ");
		}
		
		return newarr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 4, 7, 5, 10, 18, 17, 26, 30, 45, 50, 62};
		int minmumlength = 5;
		int startsort = 2;
		subsort2(arr, minmumlength, startsort);
		
	}

}
