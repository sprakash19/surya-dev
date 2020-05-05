package com.sample1.tree;

public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		
	}
	public TreeNode(int x) {
		val = x;
		this.left = null; 
        this.right = null; 
	}
	
	
	
	public  static TreeNode createTree(int i, int[] array, TreeNode node) {
		if(i < array.length) {
		node = new TreeNode(array[i]);
		node.left = createTree(2*i+1, array,node.left);
		node.right = createTree(2*i+2, array,node.right);
		}
		return node;
	}

}
