package com.sample1;

public class FindUpperLowerTargetPosInArray {
	
	public static void main(String[] args) {
		
		FindUpperLowerTargetPosInArray obj = new FindUpperLowerTargetPosInArray();
		int arr[] = {2,2};
		int val = 1;
		System.out.print(obj.searchRange(arr, val));
		
	}
	
	public int[] searchRange(int[] nums, int target) {
        int upper = nums.length -1;
		    if(nums.length ==0) {
		    	return new int[] {-1,-1};
		    }
		   int pos = find(nums, target);
		   System.out.println(pos);
           int lowerP = pos;
           int upperP = pos;
           
           if(pos == upper || pos == 0 || pos == -1) {
           return new int[]{pos, pos};    
           }
        
           if(nums[pos+1] == target) {
               int temp = pos+1;
               while(temp <= upper && nums[temp] == target) {
                   temp++;
               }
               upperP = temp-1;
           
        }
        
           if(nums[pos-1] == target) {
               int temp = pos-1;
               while(temp >= 0 && nums[temp] == target) {
                   temp--;
               }
               lowerP = temp+1;
           
        }
        return new int[]{lowerP, upperP};
		}
		     
		     
	public int find(int[] arr, int val){
        
	    int upper = arr.length-1;
	    int mid = arr.length/2;
	    if(arr.length ==0) {
	    	return -1;
	    }
	    if(arr[mid] > val && mid > 0) {
	    return 	divide(0, mid, arr ,val);	
	    }
	    else {
	   return divide(mid, upper, arr ,val);
	    }
	}
	     
	     
	private int divide(int lower, int upper, int[] array, int target) {
        
		   if(upper > 0 && array[upper] > target ) {
			   int middle = ((upper +lower)/2);
		   return divide(lower, middle, array, target);
		   }
		   else if(lower < array.length -1 && array[lower] < target) {
			  int middle = 1+(upper -lower)/2;
		  return divide(middle, upper, array, target);
		   }
		   else if(lower !=array.length && array[lower]== target) {
		       return lower ;
		   }
		   else if(upper != -1 && array[upper]== target) {
		       return upper ;
		   }
		   return -1;		   
		 
		 } 	

}
