package com.sample1;

public class MergeSortExample {
    static int[] sortedArray;
    
	public static void main(String[] args) {
	  int[] array = {7,5,3, 6, 4, 1};
		//int[] array = {4,4,4,1};
		System.out.println("Array to Sort: " );
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.print("\n");
		int aLength = array.length;	
		sortedArray = new int[aLength];
		splitArray(array, aLength);
		
		System.out.println("final sorted elements are: " );
		for(int i=0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		
		

	}
	
	private static void splitArray(int[] array, int length) {
		
		if(length <  2){
			return;
		}
		int mid = length/2;
		
		int[] leftArray = new int[mid];
		int[] rightArray = new int[length - mid];
		System.out.print("splitted left arrays: {" );
		for(int i =0; i < mid; i++) {
			leftArray[i] = array[i];
			System.out.print(leftArray[i]);
		}
		System.out.print("}\n");
		
		System.out.print("splitted right arrays: {" );
		for(int i =0,j=mid; j < length; i++,j++) {
			rightArray[i] = array[j];
			System.out.print(rightArray[i]);
		}
		System.out.print("}\n");	
		
       splitArray(leftArray, leftArray.length);
       splitArray(rightArray, rightArray.length);
       mergeSort(array, leftArray, rightArray);
	}
	
	private static void mergeSort(int[] sortedArray, int[] leftArray, int[] rightArray) {	      
		
		
		System.out.println("LeftandRightElementstoMerge");
        for(int l=0; l < leftArray.length; l++) {
			System.out.print(leftArray[l]);
		}
        System.out.print("\n");
        for(int l=0; l < rightArray.length; l++) {
			System.out.print(rightArray[l]);
		}
        System.out.print("\n");
        System.out.println("**MergingProcess Begins***");
		
		int i=0, j=0, k=0;
		while(i < leftArray.length && j< rightArray.length) {
			if(leftArray[i] <= rightArray[j]) {
				sortedArray[k] = leftArray[i];
				i++;
				k++;
			}
			else if(leftArray[i] > rightArray[j]) {
				sortedArray[k] = rightArray[j];
				j++;
				k++;
			}
		}
		
		while(i < leftArray.length) {
			sortedArray[k] = leftArray[i];
			i++;
			k++;	
		}
        while(j < rightArray.length) {
        	sortedArray[k] = rightArray[j];
			j++;
			k++;
		}
        System.out.println("**MergingProcess Ends***");
        System.out.println("***MergedElements Are***");
        for(int z=0; z < sortedArray.length; z++) {
			System.out.print(sortedArray[z]);
		}
        System.out.print("\n");
	}

}
