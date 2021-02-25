package com.prac;

public class BeautifulArrangement {

//	public static void swap(int[] nums) {
//		int last = nums[nums.length-1];
//		
//		for(int k = nums.length-1; k > 0; k--) {
//			nums[k] = nums[k-1];
//		}
//		nums[0] = last;
//		
//	}
//	
//	public static int countArrangement(int n) {
//        if(n == 1) {
//        	return 1;
//        }
//        
//        int[] nums = new int[n];
//        
//        
//        for(int i = 0; i < n; i++) {
//        	nums[0] = i+1;
//        }
//        int count = 0;
//        for(int i = 0; i < n; i++) {
//        	boolean beautiful = true;
//        	 for(int j = 0; j < nums.length; j++) {
//             	if(nums[i]%(i+1) == 0 || (i+1)%nums[i] == 0) {
//             		
//             		continue;
//             	}
//             	beautiful = false;
//             	break;
//             }
//        	 if(beautiful) {
//        		 count++;
//        	 }
//        	 swap(nums);
//        }
//        
//        return count;
//    }
	static int count = 0;
	public static int countArrangement(int n) {
		boolean[] visited = new boolean[n + 1];
		int[] perm = new int[n + 1];
		countArrangementHelper(n, perm, visited, n);
		return count;
	}

	public static void countArrangementHelper(int n, int[] perm, boolean[] visited, int vidx) {

		if (vidx == 0) {
			count++;
			return;
		}

		for (int i = n; i >= 1; i--) {
			if (!visited[i]) {
				visited[i] = true;
				perm[vidx] = i;
				if (i % vidx == 0 || vidx % i == 0)
					countArrangementHelper(n, perm, visited, vidx - 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		
		System.out.println(countArrangement(n));
	}

}
