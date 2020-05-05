package com.sample1;

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {
	
	public static void main(String args[]) {
		String s = "dvdf";
		
		List<Character> set = new ArrayList<>();
        int i=0,j=0,k=0, max=0;
        while(i < s.length()) {
           Character c = s.charAt(i);
           i++;
           if(!set.contains(c)) {
           set.add(c);
               j++;
            }
            else {
               if(max < j) {
                max = j;
               }
                k++;
                i=k;
                j=0;
                set = new ArrayList<>();
                
            }
            
               
            
         }
        if(max < j) {
            max = j;
           }
        
       System.out.println(max);
    }
		
	}


