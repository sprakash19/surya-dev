package com.sample1;

public class MergeKSortedList {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);

//		addNode(l1, 4);
//		addNode(l1, 5);
		

		ListNode l2 = null;
//		addNode(l2, 3);
//		addNode(l2, 4);

		ListNode l3 = new ListNode(-1);
		//addNode(l3, 6);
//		addNode(l3, 9);
//
//		ListNode l4 = new ListNode(10);
//		addNode(l4, 11);
//		addNode(l4, 12);
		
		
		ListNode[] lists = new ListNode[] { l1, l2, l3};
		ListNode[] sortedList = mergeKSortedLists(lists);
		
		while(sortedList != null && sortedList[0] != null) {
			System.out.print(sortedList[0].val);
			sortedList[0] = sortedList[0].next;
		}

	}
	
	
	private static ListNode[] mergeKSortedLists(ListNode[] lists) {
		ListNode[] resultList = new ListNode[lists.length-1];
		
	    int i=0;
	    int j=0;
	   
	    
	    while(i < lists.length) {
	    	ListNode result = new ListNode(-1);
	    	ListNode headNode = result;
	    	ListNode leftLN = lists[i];
	    	
	    	ListNode rightLN = i+1 < lists.length ? lists[i+1] : null;
	    while(leftLN != null && rightLN != null) {
	    	if(leftLN.val <  rightLN.val) {
	    		result.next = leftLN;
	    		leftLN = leftLN.next;
	    	}
	    	else {
	    		result.next = rightLN;
	    		rightLN = rightLN.next;
	    	}
	    	result = result.next;
	    	
	    }
	    if(leftLN != null) {
	    	result.next = leftLN;
	    }
	    if(rightLN != null) {
	    	result.next = rightLN;
	    }
	    resultList[j] = headNode.next;
	    i = i+2;
	    j++;
	    
	    }
	    if(resultList.length != 1) {
	    	resultList = mergeKSortedLists(resultList);
	    }
		return resultList;
		
	}

	private static void addNode(ListNode node, int val) {
		while (node != null) {
			ListNode newNode = new ListNode(val);
			if (node.next == null) {
				node.next = newNode;
				break;
			} else {
				node = node.next;
			}
		}
	}
}



