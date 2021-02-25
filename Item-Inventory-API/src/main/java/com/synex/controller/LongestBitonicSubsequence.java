package com.synex.controller;

public class LongestBitonicSubsequence {
	
	public int[] allocatememory(int i, int n) {
		int[] arr = new int[n]; 
        for (; i < n; i++) 
            arr[i] = 1; 
        
        return arr;
	}
	
	public int checksubseqeunce(int[] arr, int n) {
		
		int i, j;
		
		int[] lis = allocatememory(0, n); 
  
        
        for (i = 1; i < n; i++) 
            for (j = 0; j < i; j++) 
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1; 
  
       
        int[] lds = allocatememory(0, n);
        
        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--) 
            for (j = n-1; j > i; j--) 
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) 
                    lds[i] = lds[j] + 1; 
  
  
        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1; 
        for (i = 1; i < n; i++) 
            if (lis[i] + lds[i] - 1 > max) 
                max = lis[i] + lds[i] - 1; 
  
        return max; 
        
	}
	
	public int computelettoright(int lis[], int[] arr, int n, int i, int j) {
		
		if(j < i) {
			return lis[j];
		}
		
		if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
			lis[i] = computelettoright(lis, arr, n, ++i, ++j) + 1;
			return lis[j];
		}else {
			return lis[i];
		}
	}
	
	public int var(int lds[], int[] arr, int n, int i, int j) {
		if(j > i) {
			return lds[j];
		}
		
		if(arr[i] > arr[j] && lds[i] < lds[j] + 1) {
			lds[i] = computelettoright(lds, arr, n, ++i, ++j) + 1;
			return lds[j];
		}else {
			return lds[i];
		}
	}
	
	public int recursivechecksubseqeunce(int[] arr, int n) {
		
		int totalmax = 0;
		
		int o = 0;
		int g = 0;
		
		
        
		
		
		
		return totalmax;
	}
	
	
	public static void main(String[] args) {

		LongestBitonicSubsequence lb = new LongestBitonicSubsequence();
		
//		int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
//		int[] arr = {12, 11, 40, 5, 3, 1};
//		int[] arr = {80, 60, 30, 40, 20, 10};
		
//		int arr[] = {80, 60, 40, 20, 21, 22, 23, 24, 50, 30, 20, 10};
		int arr[] = {1,3,11,2,15,16, 15,9,3,7,6,4,2,8,1};
		
		System.out.println(lb.checksubseqeunce(arr, arr.length));
		
		
	}

}
