package com.sample1.linkedlist;

public class LinkListNode {
	
	String name;
	LinkListNode node;
	LinkListNode nextNode;
	LinkListNode headNode;
	int position;
	
	
	public LinkListNode(String name) {
		super();
		this.name = name;
	}
	public LinkListNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkListNode nextNode) {
		this.nextNode = nextNode;
	}
	public LinkListNode getHeadNode() {
		return headNode;
	}
	public void setHeadNode(LinkListNode headNode) {
		this.headNode = headNode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkListNode getNode() {
		return node;
	}
	public void setNode(LinkListNode node) {
		this.node = node;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	public boolean hasNext(){
		return getNextNode() != null;
	}
	
	public LinkListNode next(){
		return getNextNode();
	}

}
