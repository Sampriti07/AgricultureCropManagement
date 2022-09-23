package com.capg.agriculture.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection="CropDetails")
public class CropDetails {
	@Id
	private int id;
	@Field
	private String cropName;
	@Field
	private double quantity;
	@Field
	private double price;
	@Field
	private int farmerId;
	
	
	
	
	public CropDetails() {
		super();
		// TODO Auto-generated constructor stub
	}




	public CropDetails(int id, String cropName, double quantity, double price, int farmerId) {
		super();
		this.id = id;
		this.cropName = cropName;
		this.quantity = quantity;
		this.price = price;
		this.farmerId = farmerId;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
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




	public int getFarmerId() {
		return farmerId;
	}




	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}




	@Override
	public String toString() {
		return "CropDetails [id=" + id + ", cropName=" + cropName + ", quantity=" + quantity + ", price=" + price
				+ ", farmerId=" + farmerId + "]";
	}





	
	

}

