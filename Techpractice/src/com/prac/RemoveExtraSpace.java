package com.prac;

public class RemoveExtraSpace {

	public static String removeExtraSpace(String word) {
		
		StringBuilder newWord = new StringBuilder();
		
		word = word.trim();
		
		
		int count = 0;
		for(int i = 0; i < word.length(); i++) {
			
			if(word.charAt(i) == ' ') {
				count++;
				
				if(count > 1) {
					count--;
					continue;
				}
				newWord.append(word.charAt(i));
			}else if (word.charAt(i) == ',') {
				if(count > 0) {
					System.out.println(i-count + " " + newWord.length());
					if(i-count == newWord.length()) {
						newWord.delete(i-count-1, newWord.length());
					}else {
						newWord.delete(i-count, newWord.length());
					}
					
					
					count = 0;
				}
				newWord.append(word.charAt(i));
			}else {
				
				newWord.append(word.charAt(i));
				count = 0;
			}
	
		}
		
		
		System.out.println(newWord);
		
		return newWord.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "full  ,  stop    1";
		removeExtraSpace(word);
	}

}
