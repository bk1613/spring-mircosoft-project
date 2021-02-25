package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var words = new String[]{"This", "is", "an", "justification.", "example", "of", "text"};
		
		int maxwidth = 16;
		
		int size = -1;
		int num = 0;
		int count = 0;
		int space = 0;
		
		
		List<String> textlist = new ArrayList<>();
		
		
		for(int i = 0; i<words.length; i++) {
			size++;
			count+=words[i].length();
			num++;
			String text = "";
			System.out.println(count);
			if(num == (words.length/2)) {
				
//				if(count > 16) {
//					System.out.println(count);
//					
//					count -= words[i].length();
//					
//					
//					
//					space = maxwidth - count;
//					
//					int firstsp = space/2;
//					int secsp = space-firstsp;
//					text += words[i];
//					for(int j = 0; j<secsp;j++) {
//						text += " ";
//					}
//					for(int j = 0; j<firstsp;j++) {
//						text += " ";
//					}
//					
//					i--;
//					num = 0;
//					count = 0;
//					textlist.add(text);
//					
//					continue;
//				}
					space = maxwidth - count;
					int firstsp = space/2;
					int secsp = space-firstsp;
					text = words[i-2];
					for(int j = 0; j<secsp;j++) {
						text += " ";
					}
					text += words[i-1];
					
					for(int j = 0; j<firstsp;j++) {
						text += " ";
					}
					text += words[i];
					
					textlist.add(text);
					num = 0;
					count = 0;
				
			}
		}
		
		
		
		for(int i = size;i < words.length;i++) {
			
			String text = "";
			if(words.length-size == num) {
				
				space = maxwidth - count;
				
				int firstsp = space/2;
				int secsp = space-firstsp;
				text += words[i];
				for(int j = 0; j<secsp;j++) {
					text += " ";
				}
				for(int j = 0; j<firstsp;j++) {
					text += " ";
				}
				
				
				textlist.add(text);
			}
			num++;
		}
		
		for(String a: textlist) {
			System.out.println(a);
		}
		
	}

}
