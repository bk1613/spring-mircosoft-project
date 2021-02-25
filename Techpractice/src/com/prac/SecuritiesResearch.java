package com.prac;

public class SecuritiesResearch {

	public static int Maxdifference(int[] px) {
		
		boolean dec = false;
		int max = 0;
		for(int i = 0; i < px.length; i++) {
			int temp = 0;
			for(int j = 0; j < px.length; j++) {
				if(px[i] == px[j]) {
					break;
				}
				if(px[i] > px[j]) {
					
					temp = px[i] - px[j];
					//System.out.println(temp);
					if(temp > max) {
						max = temp;
					}
					dec = false;
				}else {
					dec = true;
				}
			}
		}
		if(dec) {
			return -1;
		}else {
			return max;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] px = {7, 1, 2, 5};
//		int[] px = {7, 5, 3, 1};
		int[] px = {7, 2, 5, 1, 3};
		System.out.println(Maxdifference(px));
	}

}
