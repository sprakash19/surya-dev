package com.sample1.linkedlist;

public class LinkedListMain {

	public static void main(String[] args) {
		
		LinkListNode node1 = new LinkListNode("Surya");
		LinkListInterface obj = new LinkListService();
		
              obj.addNode(node1);
	}

}
