package com.prac;

public class PermutationString {

	boolean match = false;
	public void helper(String s1, String s2, String s3, int i, StringBuilder temp) {
		if(s2.length()-1 < i) {
			return;
		}
		if(temp.toString().equals(s1) || temp.toString().equals(s3)) {
			System.out.println(temp);
			match = true;
			return;
		}
		
		for(int j = i; j < s2.length(); j++) {
			temp.append(s2.charAt(j));
			helper(s1, s2, s3, i+1, temp);
			temp.delete(temp.length()-1, temp.length());
		}
		
	}
	
	 public boolean check(int a[], int[] b){
	        for(int i=0;i<26;i++)
	            if(b[i]!=a[i])
	                return false;
	        return true;
	   }
	
	public boolean checkInclusion(String s1, String s2) {
		
//		String rev = "";
//		
//		for(int i = s1.length()-1; i >=0 ; i--) {
//			rev += s1.charAt(i);
//		}
//		
//		helper(s1, s2, rev, 0, new StringBuilder());
//		System.out.println(match);
		if(s1.length() > s2.length())
			return false;
		int[] cnt = new int[26];
		
		String tmp = "";
		
		for(int i = 0; i < s1.length(); i++) {
			cnt[s1.charAt(i)-'a']++;
			System.out.println(cnt[s1.charAt(i)-'a']);
		}
		System.out.println("");
		int ss = 0;
		int ee = s1.length()-1;
		int[] cur = new int[20];
		for(int i = 0; i < s1.length();i++) {
			cur[s2.charAt(i)-'a']++;
			System.out.println(cur[s2.charAt(i)-'a']);
		}
		
		while(!check(cnt, cur) && ee < s2.length()) {
			cur[s2.charAt(ss)-'a']--;
            ss++;
            ee++;
            if(ee==s2.length())
                return false;
            cur[s2.charAt(ee)-'a']++;
            
		}
		if(ee<s2.length())
                return true;
		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationString ds = new PermutationString();
		
		String s1 = "ab";
		String s2 = "eidboaoo";
		System.out.println(ds.checkInclusion(s1, s2));
	}

}
