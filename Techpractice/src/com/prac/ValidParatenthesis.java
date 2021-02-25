package com.prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParatenthesis {

	public static boolean findValidParathesis(String paran) {
		
		String[] paraArr = paran.split("");
		Queue<String> que = new LinkedList<>();
		
		Stack<String> st = new Stack<>();
		
		for(int i = 0; i < paraArr.length; i++) {
			String bra = "";
			if(paraArr[i].equals(")") || paraArr[i].equals("}") || paraArr[i].equals("]")) {
				
				bra = st.pop();
				bra += paraArr[i];
				System.out.println(bra);
				
				if(bra.equals("()") || bra.equals("[]") || bra.equals("{}")) {
					continue;
				}else {
					return false;
				}
			}else {
				st.add(paraArr[i]);
			}
			
			
			//System.out.println(que);
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findValidParathesis("(]"));
	}

}
