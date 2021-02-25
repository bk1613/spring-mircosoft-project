package com.prac;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {

	public static int calculate(String s) {
        s = s.trim();
        
		List<Character> ops = new LinkedList<>();
		List<Integer> st = new ArrayList<>();
		
		
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == ' ') {
				continue;
			}
			
			if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
				ops.add(s.charAt(i));
			}else {
				int j = Integer.parseInt(s.charAt(i)+"");
				st.add(j);
			}
			
		}
		
		Stack<Integer> num = new Stack<>();
		num.add(st.remove(0));
	
		
		for(int i = 0; i < ops.size(); i++) {
			int curr = st.get(i);
			
			switch(ops.get(i)) {
				case '*':
					curr = num.pop() * curr;
					break;
				case '/':
					curr = num.pop() / curr;
					break;
				case '-':
					curr = -curr;
					break;
				
			}
			
			num.add(curr);
			
		}
		int result = 0;
	      while (num.size() > 0) {
	          result += num.pop();
	      }
		
		System.out.println(result);
		return 0;
		
    }
	
	
//	 public int calculate(String s) {
//        s = s.trim().replaceAll(" ","");
//        String[] nums = s.split("[\\+\\-\\*/]+");
//        String[] ops = s.split("[\\d]+");
//        Stack<Integer> numsStack = new Stack<Integer>();
//        numsStack.push(Integer.parseInt(nums[0]));
//        for (int i = 1; i < ops.length; i ++) {
//            int curr = Integer.parseInt(nums[i]);
//            if (ops[i].equals("*")) {
//                curr = numsStack.pop() * curr;
//            }
//            if (ops[i].equals("/")) {
//                curr = numsStack.pop() / curr;
//            }
//            if (ops[i].equals("-")){
//                curr = -curr;
//            }
//            numsStack.push(curr);
//        }
//        int result = 0;
//        while (numsStack.size() > 0) {
//            result += numsStack.pop();
//        }
//        return result;
//    }
	 
	
//	public static int calculate(String s) {
//	    int md=-1; // 0 is m, 1 is d
//	    int sign=1; // 1 is +, -1 is -
//	    int prev=0;
//	    int result=0;
//	 
//	    for(int i=0; i<s.length(); i++){
//	        char c = s.charAt(i);
//	        if(Character.isDigit(c)){
//	            int num = c-'0';
//	            while(++i<s.length() && Character.isDigit(s.charAt(i))){
//	                num = num*10+s.charAt(i)-'0';
//	            }
//	            i--; // back to last digit of number
//	 
//	            if(md==0){
//	                prev = prev * num;
//	                md=-1;
//	            }else if(md==1){
//	                prev = prev / num;
//	                md=-1;
//	            }else{
//	                prev = num;
//	            }
//	        }else if(c=='/'){
//	            md=1;
//	        }else if(c=='*'){
//	            md=0;
//	        }else if(c=='+'){
//	            result = result + sign*prev;
//	            sign=1;
//	        }else if(c=='-'){
//	            result = result + sign*prev;
//	            sign=-1;
//	        }
//	    }
//	 
//	    result = result + sign*prev;
//	    System.out.println(result);
//	    return result;
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " 8+3/2  ";
		calculate(s);
	}

}
