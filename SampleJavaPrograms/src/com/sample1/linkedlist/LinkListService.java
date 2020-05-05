package com.sample1.linkedlist;

public class LinkListService implements LinkListInterface {
	
	LinkListNode currentNode;
	LinkListNode firstNode;
	int size=1;
	int position =0;

	@Override
	public void addNode(LinkListNode node) {
		 if(firstNode == null) {
			 setFirstNode(node);
		 }
		if(currentNode == null){
			setCurrentNode(node);
			
		    }
		else{
		currentNode.setNextNode(node);
		setCurrentNode(node);
		}
		node.setPosition(position++);
		size++;
	}

	@Override
	public void deleteNode(LinkListNode node) {
		int position = node.getPosition();
		if(node.equals(firstNode)){
		if(node.hasNext()){
		 setFirstNode(node.next());			 
		}		
		node = null;
		 return;
		}
		LinkListNode prevNode = get(position -1);
		if(node.equals(currentNode)) {
			setCurrentNode(prevNode);
		}
		
		if(node.hasNext()) {
		prevNode.setNextNode(node.next());	
		}
		
	}
	
	public int getSize(){		
		return size;
	}

	public LinkListNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(LinkListNode currentNode) {
		this.currentNode = currentNode;
	}

	public LinkListNode getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(LinkListNode firstNode) {
		this.firstNode = firstNode;
	}

	
	public LinkListNode get(int position) {	  
	  LinkListNode node = null;
	  while(firstNode.hasNext()) {
		  node = firstNode.next();
		  if(node.getPosition() == position) {
			  return node;
		  }
	  }
	return null;
	}
	

}
