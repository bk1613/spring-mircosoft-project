package com.prac;

public class StringToInteger {

	public static int convert(String num) {
		
		boolean postive = true;
		
		if(num.contains("-")) {
			postive = false;
			
		}else if(num.contains("+")) {
			postive = true;
		}
		String nospacenum = num.trim();
		String s = "";
		for(int i = 0; i < nospacenum.length(); i++) {
			try {
				
				long g = Integer.parseInt(nospacenum.charAt(i)+"");
				
				s += g+"";
				
			}catch(NumberFormatException e) {
				if(num.charAt(i) == '-') {
					continue;
				}
				break;
			}
			
		}
		//System.out.println((int)Math.pow(2, 31)+1);
		if(!postive) {
			long g = Long.parseLong(s);
			
			if(g > Math.pow(2, 31)) {
				return (int)Math.pow(2, 31)+1;
			}else if(g < -Math.pow(2, 31)) {
				return (int)Math.pow(2, 31)*-1;
			}
			
			return (int)g*-1;
		}else if(s.isEmpty()) {
			return 0;
		}else {
			int g = Integer.parseInt(s);
			return g;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		String num = "42";
		
		//System.out.println(convert("42"));
		System.out.println(convert("-42"));
		System.out.println(convert("4193 with words"));
		System.out.println(convert("words and 987"));
		System.out.println(convert("-91283472332"));
	}
}

/*
 * SQL> select e.uin, d.name from emp_uin e, emp_test d where e.id = d.id and d.age < 25 order by name, id;
select e.uin, d.name from emp_uin e, emp_test d where e.id = d.id and d.age < 25 order by name, id

*solve one question completely
*/
