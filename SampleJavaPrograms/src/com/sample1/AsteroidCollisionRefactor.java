package com.sample1;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollisionRefactor {

	public static void main(String[] args) {
		AsteroidCollisionRefactor obj = new AsteroidCollisionRefactor();
		int[] asteroids = new int[]{1, 1,-2,-2};
		List<Integer> movingAst = new ArrayList<>();
        for(int ast : asteroids) {
        	obj.addToList(movingAst, ast);
        		
        	}     
	   System.out.print(movingAst.toString());

	}
	
	private void addToList(List<Integer> movingAst, int ast) {
		       int lastAst = movingAst.size() != 0 ? movingAst.get(movingAst.size() -1) : Integer.MIN_VALUE;
	          if(lastAst < 0 && ast < 0 || lastAst > 0 && ast > 0 || lastAst < 0 && ast > 0){
	           movingAst.add(ast);
	          
	          }
	          else
	         if(lastAst > 0 && ast < 0) {
	          
	  	      if(lastAst+ast < 0) {
	  		  movingAst.remove(movingAst.size() -1);
	  		 addToList(movingAst, ast);
	  			 }
	  	     else if(lastAst+ast == 0) {
	  	    	 movingAst.remove(movingAst.size() -1);
	  	     }    
	              }
	         
	}
	   
	}


