package com.sample1;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		String s = "((()))())"; //")()())()()(";    //"(())";//()(()
		System.out.println(longestValidParentheses(s));
		
	}
	
	 public static int longestValidParentheses(String s) {
	      
	       Stack<String> st = new Stack<>();
	       
	       for(int i=0; i< s.length(); i++) {
	    	   
	    	char ch = s.charAt(i);
	    	if(ch == '(') {
	    		st.push("(");
	    	}
	    	else if(ch == ')') {
	    		if(!st.isEmpty() && st.peek().equals("(")) {
	    			st.pop();
	    			st.push("2");
	    			sumNums(st, 0);
	    			}
	    		else if(!st.isEmpty() && !(st.peek().equals("(") || st.peek().equals(")"))) {
	    			 int val = Integer.parseInt(st.pop());
	    			  if(!st.isEmpty() && st.peek().equals("(")) {
	    			  st.pop();	
	    			 val = val+2;
	    			 sumNums(st, val);
	    				}
	    			  else {
	    		    st.push(val+"");
	    		    st.push(")");
	    				}
	    		}
	    		else {
	    			st.push(")");
	    		}
	    	}
	    	   
	    	   
	       }
	       
	       int maxLength = 0;
	       while(!st.isEmpty()) {
	    	   String s1 = st.pop();
	    	   if(!(s1.equals("(") || s1.equals(")"))) {
	    		   int j = Integer.parseInt(s1);
	    		  if(maxLength < j) {
	    			  maxLength = j;
	    		  }
	    	   }
	       }
	       
	       return maxLength;
	
	       
	 }
	 
	 private static void sumNums(Stack<String> st, int val) {
  	       
			while(!st.isEmpty() && !(st.peek().equals("(") || st.peek().equals(")"))) {
   			 val = val + Integer.parseInt(st.pop());
   			}
   			st.push(val+"");
			
		}
     

}
