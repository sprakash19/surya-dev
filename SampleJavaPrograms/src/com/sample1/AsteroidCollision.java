package com.sample1;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {

	public static void main(String[] args) {
		AsteroidCollision obj = new AsteroidCollision();
		int[] asteroids = new int[]{2,1,-2,-2};
	List<Integer> movingAst =	obj.asteroidCollision(asteroids);
	System.out.print(movingAst.toString());

	}
	
	private boolean addToList(List<Integer> movingAst, int lastAst, int ast) {
		 if(lastAst == Integer.MIN_VALUE) {
	          
	           movingAst.add(ast);      
	          return true;  
	             
	         }
	          if(lastAst < 0 && ast < 0){
	           
	           movingAst.add(ast);      
	           return true;  
	          }
	          if(lastAst > 0 && ast > 0){
	          
	           movingAst.add(ast);      
	           return true;
	          }
	           if(lastAst < 0 && ast > 0){
	          
	           movingAst.add(ast);  
	          return true;
	          }
		return false;
	}
	
	
	    public List<Integer> asteroidCollision(int[] asteroids) {
	     List<Integer> movingAst = new ArrayList<>();
	        int lastAst = Integer.MIN_VALUE;
	        
	        for(int ast : asteroids) {
	        	if(addToList(movingAst, lastAst, ast)) {
	        	lastAst = ast;	
	        	continue;
	        	}
	            if(lastAst > 0 && ast < 0) {
	            	
	                if(lastAst+ast < 0) {
	                while(movingAst.size() > 0) { 
	                if(lastAst+ast < 0 && lastAst > 0 && ast < 0) {	
	                 movingAst.remove(movingAst.size() -1);
	                 if(movingAst.size() > 0) {  
	                 lastAst =  movingAst.get(movingAst.size() -1); 
	                 }
	                 else {
	                	 lastAst = Integer.MIN_VALUE;
	                	 addToList(movingAst, lastAst, ast);
	                	 break;
	                	
	                 }
	                }
	                else if(lastAst+ast == 0) {
	                	 movingAst.remove(movingAst.size() -1);
	                	 if(movingAst.size() > 0) {  
	    	                 lastAst =  movingAst.get(movingAst.size() -1); 
	    	                 }else {
	                	 lastAst = Integer.MIN_VALUE;
	    	                 }
	                }
	                else {
	                	addToList(movingAst, lastAst, ast);
	                	break;
	                }
	               
	                	
	               
	                }
	                }
	                else  if(lastAst+ast == 0) {
	                	 movingAst.remove(movingAst.size() -1);
	                	 if(movingAst.size() > 0) {  
	    	                 lastAst =  movingAst.get(movingAst.size() -1); 
	    	                 }else {
	                	 lastAst = Integer.MIN_VALUE;
	    	                 }
	                	 continue;
	                }
	                
	            	
	                }
	                
	            }
	 
	           
	       
	        
	        return  movingAst;
	    }
	}


