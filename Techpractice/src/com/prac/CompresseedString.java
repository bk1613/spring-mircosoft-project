package com.prac;

public class CompresseedString {

	public static int compress(char[] chars) {
        
		String s = "";
		int count = 0;
		for(int i = 0; i < chars.length; i++) {
			//System.out.println(count);
			if(!s.contains(chars[i]+"")) {
				if(count > 1) {
					s+=count;
				}
				s+=chars[i];
				
				count = 0;
			}
			count++;
			
		}
		if(count > 1) {
			s+=count;
		}
		System.out.println(s);
		chars = s.toCharArray();
		return s.length();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = {'a','a','b','b','c','c','c'};
		
		System.out.println(compress(chars));
		
		char[] chars2 = {'a'};
		
		System.out.println(compress(chars2));
		
		char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
		
		System.out.println(compress(chars3));
	}

}
