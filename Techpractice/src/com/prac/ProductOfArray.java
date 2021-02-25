package com.prac;

public class ProductOfArray {

	public int helper(int[] num, int count, int ind) {

		if(count == num.length) {
			
			return 1;
		}

		if(num[count] == num[ind]) {
			return helper(num, count+1, ind);
		}else {
			return helper(num, count+1, ind)*num[count];
		}
		
	}
	
	public int[] productExceptSelf(int[] nums) {
		int[] n = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			n[i] = helper(nums, 0, i);
			
		}
		
		for(int a: n) {
			System.out.println(a);
		}
		
		return nums;
        
    }
	
	/*
	 void productArray(int arr[], int n) 
    { 
  
        // Base case 
        if (n == 1) { 
            System.out.print(0); 
            return; 
        } 
        // Initialize memory to all arrays 
        int left[] = new int[n]; 
        int right[] = new int[n]; 
        int prod[] = new int[n]; 
  
        int i, j; 
  
        // Left most element of left array  
			is always 1 
        left[0] = 1; 
  
        // Rightmost most element of right  
			array is always 1 
        right[n - 1] = 1; 
  
        // Construct the left array 
        for (i = 1; i < n; i++) 
            left[i] = arr[i - 1] * left[i - 1]; 
  
        // Construct the right array 
        for (j = n - 2; j >= 0; j--) 
            right[j] = arr[j + 1] * right[j + 1]; 
  
        // Construct the product array using  
        left[] and right[] 
        for (i = 0; i < n; i++) 
            prod[i] = left[i] * right[i]; 
  
        // print the constructed prod array 
        for (i = 0; i < n; i++) 
            System.out.print(prod[i] + " "); 
  
        return; 
    }

	 */
	
	
	public static void main(String[] args) {
		
		ProductOfArray poa = new ProductOfArray();
		int[] arr = {1, 2, 3, 4, 5};
		poa.productExceptSelf(arr);
		

	}

}
