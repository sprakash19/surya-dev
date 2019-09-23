package com.notableapp.models;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Doctor implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Doctor(String fName, String lName, long id) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		
	}

	private String fName;
	
	private String lName;
	
	private long id;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	

}
