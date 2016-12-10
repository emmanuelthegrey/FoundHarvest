package com.team.treasure;

import java.util.Date;

public class Donation {

	private int idCompanyDonation;
	private int companyID;
	private String productDescription;
	private Date expirationDate;
	private String status;
	private Date submissionDate;
	private Date confirmationDate;
	
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
	
	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}
	
	
	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
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


	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
