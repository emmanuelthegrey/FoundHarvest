package com.team.treasure;

import java.time.LocalDate;

public class Donation {

	private String nameOfDonor;
	private String address;
	private String productDescription;
	private int itemQuantity;
	private LocalDate expirationDate;
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
	

	public String getNameOfDonor() {
		return nameOfDonor;
	}

	public void setNameOfDonor(String nameOfDonor) {
		this.nameOfDonor = nameOfDonor;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmissionID() {
		return nameOfDonor;
	}

	public void setSubmissionID(String submissionID) {
		this.nameOfDonor = submissionID;
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

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

}
