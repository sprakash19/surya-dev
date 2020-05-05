package com.sample1;

public class MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
      ListNode l1 = new ListNode(1);
      
        addNode(l1, 3);
        addNode(l1 ,4);
        addNode(l1 ,5);
      
      ListNode l2 = new ListNode(1);
   addNode(l2,2);
     addNode(l2,4);
     
      ListNode result =  mergeTwoLists(l1, l2);
      printResult(result);
      
	}
	private static void printResult(ListNode result) {
		while(result != null) {
			System.out.print(result.val);
			result = result.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode result = null;
		ListNode headNode = null;
         while(l1 != null || l2 !=null) {
             
        if(l1!= null && l2 !=null && l1.val <= l2.val) {
        	if(result == null) {
           result = new ListNode(l1.val);
           result.next = new ListNode(l2.val);
           headNode = result;
        	}
        	else {
        		addResult(result, l1.val, l2.val);
               
        	}
          
        }
        
        if(l1!= null && l2 !=null && l1.val > l2.val) {
        	if(result == null) {
           result = new ListNode(l2.val);
           result.next = new ListNode(l1.val);
           headNode = result;
        	}
        	else {
        		addResult(result, l2.val, l1.val);
        		
               
        	}
          
        }
        if(l1 == null && l2 != null) {
        	if(result == null) {
                return l2;
             	}
        	else {
        		addResult(result, l2.val, -1);
        	}
        }
        
        if(l2 == null && l1 != null) {
        	if(result == null) {
                return l1;
             	}
        	else {
        		addResult(result, l1.val, -1);
        	}
        }
       
         
        
          l1 = l1.next;
          l2= l2.next; 
        
         }
         return headNode;
    }
	
	private static void addResult(ListNode result, int val1, int val2) {
		
		while(result != null) {
			if(result.next == null) {
				result.next = new ListNode(val1);
				if(val2 != -1) {
				result.next.next = new ListNode(val2);
				}
				break;
			}
			else {
				result = result.next;
			}
		}
	}
	
	private static void addNode(ListNode node, int val) {
		while(node != null) {
		ListNode newNode = new ListNode(val);
		if(node.next == null) {
		node.next = newNode;
		break;
		}
		else {
		node = node.next;
		}
		}
		
	}

}


 
  class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
	public ListNode() {
		// TODO Auto-generated constructor stub
	}
 }
 
