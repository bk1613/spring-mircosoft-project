package com.prac;

public class MaximumOrderVolu {

	
	public static int phoneCalss(int[] start, int[] duration, int[] volume) {
		
		int max = 0;
		//int[] end = new int[start.length];
		

		
		for(int i = 0; i < start.length; i++) {
			int tot = volume[i];
			int star = start[i];
			int end = start[i] + duration[i];
			for(int j = 0; j < start.length; j++) {
				if(i == j) {
					continue;
				}
				
				if(( start[j] < star  && star <= start[j] + duration[j]) || (star < start[j] && start[j] <= end)) {
					continue;
				}else if((start[j] < end && end <= start[j] + duration[j]) || (star < start[j] + duration[j] && start[j] + duration[j] <= end)) {
					continue;
				}else {
					if(start[j] > end) {
						star = start[j];
						end = start[j] + duration[j];
					}
				}
				
				
				tot += volume[j];
			}
			max=Math.max(tot, max);
		}
		System.out.println(max);
		return max;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = new int[] {10,5,15,18,30};
        int[] duration = new int[] {30,12,20,35,35};
        int[] volume = new int[] {55,51,20,25,60};
		phoneCalss(start, duration, volume);
		
	}

}
