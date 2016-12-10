package com.team.treasure;

import java.util.Date;

public class Donation {

	private int idCompanyDonation;
	private int companyID;
	private String productDescription;
	private int weight;
	private Date expirationDate;
	private String status;


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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}



	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
