package com.sample1;

import java.util.Arrays;
import java.util.Collections;

public class EditDistanceWithoutMemo {

	static int min(int insert, int remove, int replace) {
	    Integer[] values = { insert, remove, replace };
	    return Collections.min(Arrays.asList(values));
	  }

	  static int calculateEditDistance(String str1, String str2, int i, int j) {
	    
	    // If i is 0, we're essentially looking at an empty substring of str1.
	    // To convert an empty substring to any other string, you just insert 
	    // every character from the other string. Since the only operation to be 
	    // performed is insertion, the cost is equal to the length of the other 
	    // string.
	    if (i == 0) {
	      return j;
	    }

	    // This goes the other way as well of course — if you need to get from
	    // some substring to an empty string, The shortest path is to simply 
	    // remove every character in the substring.
	    if (j == 0) {
	      return i;
	    }

	    // If the characters in the strings at a particular value of i and j match,
	    // then we don't need to perform any operation and the cost is 0. Since
	    // Java is a 0-indexed language, we need to subtract 1, otherwise we'd
	    // get a StringIndexOutOfBoundsException.
	    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	      return calculateEditDistance(str1, str2, i - 1, j - 1);
	    }

	    // Otherwise, we need to recurse. Note that we're using Levenshtein 
	    // distance here.
	    return min(1 + calculateEditDistance(str1, str2, i, j - 1),      // insert
	               1 + calculateEditDistance(str1, str2, i - 1, j),      // remove
	               1 + calculateEditDistance(str1, str2, i - 1, j - 1)); // substitute
	  }

	  public static void main(String[] args) {
	    String str1 = "he";
	    String str2 = "ha";
	    int minDistance = calculateEditDistance(
	        str1, str2, str1.length(), str2.length()
	      );
	    System.out.println(minDistance);
	  }

}
