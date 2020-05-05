package com.sample1;

public class Monotonic {

	public static void main(String[] args) {
		int[] A= new int[] {1,2,2,3};
		System.out.print(isMonotonic(A));

	}
	
	public static boolean isMonotonic(int[] A) {
        int i =0;
      
        String monotonic = "";
        
        for(int j = 1; j < A.length; j++) {
            if(A[i++] == A[j]){
              if(monotonic == "") {
                monotonic = "same";
              }
            }
            else
            if(A[i++] < A[j] ){
                if(monotonic.equals("decreasing")) {
                  return false;  
                }
             monotonic = "increasing"; 
            }
            else if(A[i++] > A[j]){ 
                if(monotonic.equals("increasing")) {
                  return false;  
                }
             monotonic = "decreasing";
                
            }
           
        }
        return true;
        
    }

}
