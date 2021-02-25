package com.prac;

import java.util.regex.Pattern;

public class LongestAbsoluteFilePath {

	public static int helper(String[] input, int max, String s, int count, int numt) {
		
		System.out.println(s.substring(0, s.length()-1) + " " +s.substring(0, s.length()-1).length()+ " "+numt +" " + count);
		if(s.contains(".") && (input[input.length-1].length() - input[input.length-1].trim().length()) == count)  {
			
			return s.substring(0, s.length()-1).length();
			
			
		}
		
		
		if(!s.contains(".") && (input[count].length() - input[count].trim().length()) == numt) {
			
			return 1;
		}

		for(int i = count; i < input.length; i++) {
			
			int re = helper(input, max, s+input[i].trim()+"/", i+1, numt+1);
			max = Math.max(max, re);
		}

		return max;
	}
	
	
	public static int lengthLongestPath(String input) {
		
		String[] inarr = input.split("\n");
		
		for(String s: inarr) {
			System.out.println(s.length() + " "+ s.trim().length());
		}
		
		int m = helper(inarr, 0, inarr[0]+"/", 1 , 0);
		System.out.println(m);
		return 0;
    }
//	
//	public static int lengthLongestPath(String input) {
//		
//		String[] files = input.split("\n");
//        int[] stack = new int[files.length + 1];
//        int maxLength = 0;
//        stack[0] = 0;
//        for (String s : files) {
//            int level = s.lastIndexOf("\t") + 1;
//            int curLength = stack[level] + s.length() - level + 1;
//            stack[level + 1] = curLength;
//            if (s.contains(".")) {
//                maxLength = Math.max(maxLength, curLength - 1);
//            }
//        }
//        return maxLength;
//		
//		
//    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		
		System.out.println(lengthLongestPath(input));
	}

}
