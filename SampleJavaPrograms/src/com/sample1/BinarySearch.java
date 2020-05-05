package com.sample1;

public class BinarySearch {
	
	public static void main(String[] args) {
		BinarySearch obj = new BinarySearch();
		int arr[] = {0,1,2,3,4,4,4};
		int val = 5;
		int start =0;
		int end = arr.length -1;
		System.out.print(obj.search(arr, val, start, end));
		
	}
	
	private int search(int[] arr, int val, int start, int end) {
		 int middle = (start+end)/2;
		 if(start > end || end < start) {
			 return -1;
		 }
		if( val  == arr[middle]) {
			return middle; 
		}
		if(val > arr[middle]) {
			start = middle+1;
		}
		if(val < arr[middle]) {
		 end = middle-1;	
		}
		return search(arr, val, start, end);
		
	
	}

}
