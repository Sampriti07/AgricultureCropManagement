package com.capg.agriculture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="Farmer")
public class Farmer {
	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String emailid;
	@Field
	private long ph_no;
	
	
	public Farmer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Farmer(String id,String name, String emailid, long ph_no) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.ph_no = ph_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", emailid=" + emailid + ", ph_no=" + ph_no + "]";
	}

	


	

}

