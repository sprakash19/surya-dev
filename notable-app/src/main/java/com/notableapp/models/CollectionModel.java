package com.notableapp.models;

import java.io.Serializable;
import java.util.List;


public class CollectionModel<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	

}
