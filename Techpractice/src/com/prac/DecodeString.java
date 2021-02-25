package com.prac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Exp {
    int count;
    List<Exp> list;
    char c;
 
    public Exp(int num) {
        count = num;
        list = new ArrayList<>();
    }
 
    public Exp(char ch) {
        c = ch;
    }
 
    public String getStr() {
        String result = "";
 
        if (list != null) {
            for (int i = 0; i < count; i++) {
                for (Exp e : list) {
                    result += e.getStr();
                }
            }
        } else {
            result += c;
        }
 
        return result;
    }
}


public class DecodeString {

//	public static String decodeString(String s) {
//		
//		List<Integer> nums = new ArrayList<>();
//		List<String> letters = new ArrayList<>();
//		Stack<Character> st = new Stack<>();
//		String result = "";
//		int numops = 0;
//		int rest = 0;
//		for(int i = 0; i < s.length(); i++) {
//			//System.out.println(s.charAt(i));
//			
//			if(Character.isDigit(s.charAt(i))) {
//				int a = Integer.parseInt(s.charAt(i)+"");
//				nums.add(a);
//			}else if(s.charAt(i) == ']') {
//				String sub = "";
//				int count = st.size()-1;
//				while(st.get(count) != '[') {
//					//System.out.println(st.get(count));
//					sub = st.get(count) + sub;
//					st.remove(count);
//					count--;
//				}
//				System.out.println(sub);
//				st.remove(count);
//				//System.out.println(sub);
//				String temp = "";
//				
//					for(int j = 0; j < nums.get(nums.size()-1); j++) {
//						letters.add(sub);
//					}
//					
//					
//				
//				
//				if (st.contains('[')){
//						count--;
//					
//						String t = "";
//						for(String a: letters) {
//							t += a;
//						}
//						System.out.println(t);
//						letters.clear();
//						sub = "";
//						while(st.get(count) != '[') {
//							//System.out.println(st.get(count));
//							sub = st.get(count) + sub;
//							st.remove(count);
//							count--;
//						}
//						
//						//nums.remove(nums.size()-1);
//						
//						System.out.println("n "+ sub);
//						System.out.println(nums.size()-1);
//						for(int j = 0; j < nums.get(nums.size()-2); j++) {
////							letters.add(sub);
//							if(t.charAt(0) > sub.charAt(0)) {
//								letters.add(sub+t);
//							}else {
//								letters.add(t+sub);
//							}
//							
//						}
//					
//					
//				}
//				
//				nums.remove(nums.size()-1);
//			}else if(s.charAt(i) == '['){
//				numops++;
//				if(!st.contains('[')) {
//					for(char c: st) {
//						result += c;
//					}
//					st.clear();
//				}
//				
//				st.push(s.charAt(i));
//			}else
//			{
//				//System.out.println(s.charAt(i));
//				st.push(s.charAt(i));
//			}
//			
//		}
//		
//		for(String word: letters) {
//			result += word;
//		}
//		for(Character word: st) {
//			result += word;
//		}
//		System.out.println(result);
//		System.out.println(letters);
//		return s;
//    }
	
	public static String decodeString(String s) {
        Stack<Exp> stack = new Stack<>();
 
        Exp e = new Exp(1);
        stack.push(e);
 
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num + c;
            } else if (c == '[') {
                if (num.length() == 0)
                    continue;
 
                int value = Integer.parseInt(num);
                num = "";
                Exp exp = new Exp(value);
                stack.push(exp);
            } else if (c == ']') {
                Exp top = stack.pop();
                stack.peek().list.add(top);
            } else {
                stack.peek().list.add(new Exp(c));
            }
        }
 
        Exp root = stack.pop();
 
        return root.getStr();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2[abc]3[c2[ef2[d]]]";
		
		System.out.println(decodeString(s));
	}

}
