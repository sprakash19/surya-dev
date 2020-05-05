package com.sample1;

public class FindTargetInArray {
	
	public static void main(String[] args) {
		
		FindTargetInArray obj = new FindTargetInArray();
		int arr[] = {0,1,2,3,4,4,4};
		int val = 2;
		System.out.print(obj.find(arr, val));
	}

	public int find(int[] arr, int val){
                            
		    int upper = arr.length-1;
		    int mid = upper/2;
		    if(arr.length ==0) {
		    	return -1;
		    }
		    
		    return 	divide(0, upper, arr , mid, val);
		    
		}
		     
		     
private int divide(int lower, int upper, int[] array, int middle, int target) {
        
		if(array[middle]== target) {
		       return middle ;
		  }
		else
		
		  if(array[middle] > target ) {
			   upper = middle;
			   middle = (upper +lower)/2 ;
			if(middle == lower && array[middle] != target ) {
			return -1;
		}   
		   return divide(lower, upper, array, middle, target);
		   }
        else 
		   if(array[middle] < target) {
			  lower = middle;
			  int sum = lower+upper;
			  if(sum%2 == 0) {
				  middle = sum/2;
			  }else {
			  middle = 1+(sum/2);
			  }
               if(middle > upper) return -1;
               if(middle == upper && array[middle] != target ) {
			return -1;
		} 
		   return divide(lower, upper, array, middle, target);
		   }
		   
		    
		   return -1;		   
		 
		 } 
	
	
	
}

