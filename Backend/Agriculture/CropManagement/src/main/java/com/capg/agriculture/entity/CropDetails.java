package com.capg.agriculture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="CropDetails")
public class CropDetails {
	@Id
	private String id;
	@Field
	private String cropName;
	@Field
	private double quantity;
	@Field
	private double price;
	@Field
	private String ph_no;
	
	
	
	
	public CropDetails() {
		super();
		// TODO Auto-generated constructor stub
	}




	public CropDetails(String id, String cropName, double quantity, double price, String ph_no) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.quantity = quantity;
		this.price = price;
		this.ph_no = ph_no;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getCropName() {
		return cropName;
	}




	public void setCropName(String cropName) {
		this.cropName = cropName;
	}




	public double getQuantity() {
		return quantity;
	}




	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getPh_no() {
		return ph_no;
	}




	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}




	@Override
	public String toString() {
		return "CropDetails [id=" + id + ", cropName=" + cropName + ", quantity=" + quantity + ", price=" + price
				+ ", ph_no=" + ph_no + "]";
	}





	
	

}

