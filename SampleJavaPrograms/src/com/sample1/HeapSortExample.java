package com.sample1;

public class HeapSortExample {
	
	public static void main(String[] args) {
		int[] array = {3,1,2,5};
		sort(array);
		System.out.println("Sorted array : ");
		for(int a : array)
			System.out.println(a);
	}
	
	private static void sort(int[] array) {
		int size = array.length;
		for(int i=size -1/2; i>=0 ; i--) {
		heapify(array, size, i);
		}
		for(int j =size-1; j >=0; j--) {
		int temp = array[0];
		array[0]= array[j];
		array[j]=temp;
		heapify(array, j, 0);
		}
	}


	private static void heapify(int[] a, int size, int i){
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if(left < size && a[left] > a[largest]) {
		largest= left;	
		}
		if(right < size && a[right] > a[largest]) {
			largest = right;	
			}
		if(largest != i) {
			int temp = a[i];
			a[i]= a[largest];
			a[largest]=temp;
			heapify(a, size, largest);
		}
	}

	
}
