package com.prac;

public class PalindromicSubStrings {
	int count;
	public void helper(String s, int i, StringBuilder temp) {
		
		if(i > s.length()) {
			return;
		}
		String t = "";
		for(int k = 0; k < i; k++) {
			t += s.charAt(k);
		}
		
		if(!t.equals(temp)&&t.equals(temp.toString())) {System.out.println(temp);
			count++;
		}
		
		for(int j = 0; j < s.length(); j++) {
			temp.append(s.charAt(j));
			helper(s, i+1, temp);
			temp.delete(temp.length()-1, temp.length());
		}
		
	}
	
	private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
        	System.out.println(s.charAt(start) + " "+ s.charAt(end));
            if (s.charAt(start) != s.charAt(end)) 
                return false;

            ++start;
            --end;
        }

        return true;
    }
	
	public int countSubstrings(String s) {
        
//		helper(s, 0, new StringBuilder());
		
		int ans = 0;
		for(int start = 0; start < s.length(); start++) {
			for(int end = start; end < s.length(); ++end) {
				ans += isPalindrome(s, start, end)? 1 : 0;
			}
		}
		
		return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		PalindromicSubStrings ps = new PalindromicSubStrings();
		
		System.out.println(ps.countSubstrings(s));
	}

}
