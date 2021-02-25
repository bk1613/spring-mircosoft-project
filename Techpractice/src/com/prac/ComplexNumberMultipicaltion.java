package com.prac;

public class ComplexNumberMultipicaltion {

	public static String complexNumberMultiply(String a, String b) {
        
		String complex = "";
		String[] arrA = a.split("\\+");
		int a1 = Integer.parseInt(arrA[0]);
		
		 
		String sa2 = "";
		for(int i = 0; i < arrA[1].length()-1; i++) {
			sa2 += arrA[1].charAt(i);
		}
		int a2 = Integer.parseInt(sa2);
		System.out.println(a2);
		String[] arrB = b.split("\\+");
		int b1 = Integer.parseInt(arrB[0]);
		
		String sb2 = "";
		for(int i = 0; i < arrB[1].length()-1; i++) {
			sb2 += arrB[1].charAt(i);
		}
		
		
		int b2 = Integer.parseInt(sb2);
		System.out.println(b2);
		int i2 = -1*(b2*a2);
		
		int are = a1*b1;
		int bre = a2*b1;
		int cre = a1*b2;
		int result = are+i2;
		int re2 = bre+cre;
		
		complex += result + "+" + re2 +"i";
		System.out.println(complex);
		return complex;
		
    }
	
	public static void main(String[] args) {
		complexNumberMultiply("1+2i", "1+1i");
	}
	
}
