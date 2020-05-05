package com.sample1;

public class AtoI {

	
	public static void main(String args[]) {
		
		String s = "++1";
		System.out.println(myAtoi(s));
		//System.out.println(Integer.MAX_VALUE);
	}
	
	
	public static int myAtoi(String str) {
		str = str.trim();
		int result=0;
		//StringBuilder sb = new StringBuilder();
		boolean foundDigit = false;
		boolean negSign = false;
		boolean posSign = false;
		
		for(int i=0; i< str.length(); i++) {
		char ch = str.charAt(i);
		
		if(Character.isDigit(ch)) {
			foundDigit = true;
			int intChar = Character.getNumericValue(ch);
			
		if(result <= Integer.MAX_VALUE/10 && !(result == Integer.MAX_VALUE/10 && intChar >= 8)) {	
		result = result*10+	intChar;
		}
		else {
			return negSign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
		}
		}
		else if(foundDigit && Character.isSpaceChar(ch)) {
		break;	
		}
		else if(!foundDigit) {
			if(ch == '-' && !negSign) {
			negSign = true;
			}
			else if (ch == '+' && !posSign) {
			posSign = true;
			}
		    else {
			return 0;
			}
			if(posSign && negSign) {
				return 0;
			}
			continue;
		}	
			
		
		else {
			break;
		}
		}
		
	return negSign ? -1*result : result;
	}
	
//	public static boolean isInt(char ch) {
//		try {
//			Integer.parseInt(Character.isDigit(ch) )
//		}
//	}
}
