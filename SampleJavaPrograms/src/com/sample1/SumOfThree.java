package com.sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] nums =new int[] {-2,-1,0,1,1,2};
       List<List<Integer>> integerList = threeSum(nums);
       
       for(int i = 0; i < integerList.size(); i++) {
    	   List integers = integerList.get(i);
    	   System.out.print("[");
    	   for(int j = 0; j < integers.size(); j++) {
    		System.out.print (integers.get(j));
    	   }
    	   System.out.print("]");
    	   System.out.print("\n");
       }
	}
	
public static List<List<Integer>> threeSum(int[] nums) {
	
	 List<List<Integer>> integerList = new ArrayList<>();
	if(nums.length > 1) {
       Arrays.parallelSort(nums);
	}
	else {
		return integerList;
	}
	
	List<Integer> negativeList = new ArrayList();
	List<Integer> positiveList = new ArrayList();
       //-4,-1,-1,0,1,2
       for(int i =0; i < nums.length; i++) {
    	   
    	   if(nums[i] <= 0) {
    		   negativeList.add(nums[i]);  
    	   }
    	   else {
    		   positiveList.add(nums[i]);
    	   }
       }
      
       
       for(int i= 0; i < negativeList.size(); i++) {
    	   if(nums[i] <=0) {
    	  int x =  nums[i] + nums[i+1];
    	  int j = nums.length -1;
    	  while( j > i+1) {
    		  if(nums[j] < 0) {
    			 break;
    		  }
    		  if(nums[j] < -1*x) {
    			  break;
    		  }
    		  if(nums[j] == -1*x) {
    			  List<Integer>  integers = new ArrayList<>();
   		       
     			 integers.add(nums[i]);
     			 integers.add(nums[i+1]);
     			 integers.add(nums[j]);
     			 if(!integerList.contains(integers)) {
     			 integerList.add(integers);
     			 }
     			 
    			  
    		  }
    		  j--;
    	  }
    			
    		  }
    	  }
    		  
    	
       
       return integerList;
    }

}
