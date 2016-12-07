package com.team.treasure;

import java.time.LocalDate;

public class Donation {

	private int idCompanyDonation;
	private int companyID;
	private String productDescription;
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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCompanyID() {
		return companyID;
	}


	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}


	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

}
