package com.sample1;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String s  = "a ";
		String[] s1 = s.split(" ");
		int count = 0;
		if(s1.length != 0) {
			count = s1[s1.length -1].length();
		}
			
     System.out.println(count);
	}

}
