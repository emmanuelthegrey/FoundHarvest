package com.team.treasure;

import java.time.LocalDate;

public class Donation {

	private int idCompanyDonation;
	private String nameOfCompany;
	private String address;
	private String productDescription;
	private int itemQuantity;
	private int expirationDate;
	private String status;
	
	// calc method
	// private String category;
	// private String dateSubmission;
	// private String daysGood;
	// private String readyPickup;
	// private String pickupTime;
	
	// private String storageLocation;

	public Donation(){
		super();
	}
	

	public int getIdCompanyDonation() {
		return idCompanyDonation;
	}


	public void setIdCompanyDonation(int idCompanyDonation) {
		this.idCompanyDonation = idCompanyDonation;
	}


	public String getNameOfCompany() {
		return nameOfCompany;
	}

	public void setNameOfCompany(String nameOfCompany) {
		this.nameOfCompany = nameOfCompany;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

}
