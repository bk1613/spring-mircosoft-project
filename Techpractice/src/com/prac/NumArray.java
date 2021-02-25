package com.prac;

public class NumArray {

	int[] nums;
	
	public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public void update(int index, int val) {
    	if(nums == null ||index >= nums.length) {
    		return;
    	}
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int total = 0;
    	if(nums == null ||right >= nums.length) {
    		return 0;
    	}
    	
    	for(int i = left; i <= right; i++) {
    		total += nums[i];
    	}
    	
    	return total;
    }
	
	public static void main(String[] args) {
		
		int[][] numsarray = {{1 ,3, 5}, {0, 2}, {1, 2}, {0,2}};
		String[] inp = {"NumArray", "sumRange", "update", "sumRange"};
		
		Integer[] n = new Integer[numsarray.length];
		
		NumArray numArray = null;
		
		for(int i = 0; i < inp.length; i++) {
			
			if(inp[i].equals("NumArray")) {
				
				numArray = new NumArray(numsarray[0]);
				
			}else if(inp[i].equals("sumRange")) {
				
				if(numArray == null) {
					continue;
				}
				int re = numArray.sumRange(numsarray[i][0], numsarray[i][1]);
				n[i] = re;
			}else if(inp[i].equals("update")) {
				if(numArray == null) {
					continue;
				}
				numArray.update(numsarray[i][0], numsarray[i][1]);
			}
			
		}
		
		for(Integer a: n) {
			
			System.out.print(a + " ");
		}
		
		 

	}

}
