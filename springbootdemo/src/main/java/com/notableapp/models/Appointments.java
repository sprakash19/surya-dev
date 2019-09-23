package com.notableapp.models;

import java.io.Serializable;
import java.util.Date;

public class Appointments implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private long docId;
	private String patientName;
	private String date;
	private String kind;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	// Kind enums
    public static enum Kind{
        FOLLOWUP ("Follow-up"), 
        NEWPATIENT ("New Patient"); 
        private final String value;
        
        Kind(String strValue){
            value = strValue;
        }
        public String strValue(){
            return value;
        }
    }
	

}
