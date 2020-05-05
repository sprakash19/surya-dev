package com.sample1.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxLevelSumBinaryTree {

	public static void main(String[] args) {
	 
	int[] array = new int[] {989,0,10250,98693,-89388,0,0,0,-32127};
	TreeNode root = TreeNode.createTree(0, array, null);
	//printTree(root);
	System.out.print(maxLevelSum(root));
	}
	
	private static void printTree(TreeNode node) {
		
		if(node != null) {
			System.out.println(node.val);
			printTree(node.left);
			printTree(node.right);
		}
	}
	
//	 public static int maxLevelSum(TreeNode root) {
//	     int level = 1;
//	     int maxSum = Integer.MIN_VALUE;
//	     int targetLevel = -1;   
//	      Queue<Map<TreeNode, Integer>> que = new LinkedList<>(); 
//	      Map<Integer, Integer> levelSum = new HashMap<>(); 
//	      Map<TreeNode, Integer> levelMap = new HashMap<>();
//	      levelMap.put(root, 1);
//	      que.add(levelMap); 
//	       while(que.size() > 0) {
//	        levelMap = que.remove();
//	        TreeNode node =  levelMap.entrySet().iterator().next().getKey();
//	        level = levelMap.get(node);
//	           if(targetLevel ==-1){
//	               targetLevel = level;
//	               maxSum = node.val;
//	           }else if(levelSum.get(level) > maxSum){
//	               targetLevel = level;
//	               maxSum = levelSum.get(level);
//	           }
//	         if(node.left != null){
//	           levelMap = new HashMap<>();
//	           levelMap.put(node.left, level+1); 
//	            que.add(levelMap);
//	            if(levelSum.get(level+1) == null){
//	   	         levelSum.put(level+1, node.left.val);  
//	   	       } else {
//	   	           int sum = levelSum.get(level+1)+node.left.val;
//	   	           levelSum.put(level+1, sum);
//	   	       }
//	         }
//	           if(node.right != null) {
//	           levelMap = new HashMap<>();
//	           levelMap.put(node.right, level+1);  
//	           que.add(levelMap);
//	           if(levelSum.get(level+1) == null){
//	  	         levelSum.put(level+1, node.right.val);  
//	  	       } else {
//	  	           int sum = levelSum.get(level+1)+node.right.val;
//	  	           levelSum.put(level+1, sum);
//	  	       }
//	         } 
//	       }
//	        return targetLevel;
//	    }
	
	public static int maxLevelSum(TreeNode root) {
		
		 int level = 1;
	     
	        
	      Queue<TreeNode> que = new LinkedList<>(); 
	     
	    	  que.add(root);
	    	  int targetLevel = level;
	    	  int maxSum = root.val;
	      
	      while(que.size() > 0) {
	    	int nodes = que.size();
	    	int levelSum = Integer.MIN_VALUE;
	    	while(nodes > 0) {
	    		root = que.remove();
	    		if(levelSum == Integer.MIN_VALUE) {
	    			levelSum = root.val;
	    		}
	    		else {
	    			levelSum = levelSum+root.val;
	    		}
	    		 if(root.left != null){
	  	          que.add(root.left); 
	  	         }
	  	           if(root.right != null) {
	  	        	   que.add(root.right);
	  	           
	    	}
	    	nodes--;  
	      }
	    	if(levelSum > maxSum) {
	    		maxSum = levelSum;
	    		targetLevel = level;
	    		
	    	}
	    	level++;
	    	
	      }
	      
	      return targetLevel;
		
	}

}
