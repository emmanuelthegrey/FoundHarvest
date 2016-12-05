package com.team.treasure;

import java.time.LocalDate;

public class Donation {

	private String nameOfDonor;
	private String address;
	private String productDescription;
	private int itemQuantity;
	private LocalDate expirationDate;

	// calc method
	// private String category;
	// private String dateSubmission;
	// private String daysGood;
	// private String readyPickup;
	// private String pickupTime;
	// private String status;
	// private String storageLocation;

	public Donation(String submissionID, String address, String productDescription, int itemQuantity,
			LocalDate expirationDate) {
		this.nameOfDonor = submissionID;
		this.address = address;
		this.productDescription = productDescription;
		this.itemQuantity = itemQuantity;
		this.expirationDate = expirationDate;
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
