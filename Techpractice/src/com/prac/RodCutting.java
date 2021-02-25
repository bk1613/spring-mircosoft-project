package com.prac;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {

	int number = 0;
    public void helper(int[] rodlengths, int rodlength, int i, int num, Map<Integer, Integer> map, int sum){
        
        if(i > rodlengths.length-1){
            return;
        }
        
        if(num == rodlength){
//        	System.out.println(num);
//        	System.out.println(sum);
        	number = Math.max(sum, number);
        	return;
        }
        int s = 0;
        for(int j = 0; j < rodlengths.length; j++){
        	
            num += rodlengths[j]; 
            
            sum += map.get(rodlengths[j]);
            
           helper(rodlengths, rodlength, i+1, num, map, sum);
           num -= rodlengths[j]; 
           //s = Math.max(a, sum);
           sum -= map.get(rodlengths[j]);
        }
       
    }
    
    public int cuttingrod(int[] rodlengths, int[] price, int rodlength){
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < rodlengths.length; i++){
            
            map.put(rodlengths[i], price[i]);
            
        }
        System.out.println(map);
        helper(rodlengths, rodlength, 0, 0, map, 0);
        System.out.println(number);
        return number;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rodlengths = {1, 2, 3, 4, 5 , 6 ,7, 8};
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
		int rodlength = 8;
		RodCutting rc = new RodCutting();
		rc.cuttingrod(rodlengths, price, rodlength);
	}

}
