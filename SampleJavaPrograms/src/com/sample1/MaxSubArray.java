package com.sample1;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] nums = new int[] {2,-3,1,3,-3,2,2,1}; 
		int max = nums[0];
		List<Integer> currSubArray = new ArrayList<>();
		List<Integer> finalSubArray = new ArrayList<>();
		int currMax = max;
		
		for(int i =0; i< nums.length; i++) {
			int currNum = nums[i];
			if(currNum >= max || currNum > 0) {
			currMax = currNum;
			currSubArray = new ArrayList<>();
		    currSubArray.add(currNum);
			}
			else {
				continue;
			}
		 int j = i+1;
		 int currSum = currNum;
		 while(j < nums.length) {
			 if(currSum + nums[j] < 0) {
				 break;
			 }
			
			  currSum = nums[j]+currSum;
              if(currSum < 0) {
            	  break;
				 
			 }
			 if(currSum > currMax) {
			currMax = currSum;
			 }
			currSubArray.add(nums[j]);
			j++;
		 }
		 if(currMax > max) {
			 max = currMax;
			 finalSubArray = currSubArray;
		 }
		
			
		}
		
		System.out.println("Max is "+ max);
		System.out.println("SubArray is " );
		for(int num : finalSubArray) {
			System.out.print(num + ", ");
		}

	}

}
