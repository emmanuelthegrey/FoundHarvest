package com.team.treasure;

public class CompanyProfile {

	private String companyID;
	private String companyName;
	private String address;
	private String mainContact;
	private String companyPhoneNumber;
	private String mobileNumber;
	private String email;
	private String twitterName;

	public CompanyProfile() {
		super();
	}

	public String getTwitterName() {
		return twitterName;
	}

	public void setTwitterName(String twitterName) {
		this.twitterName = twitterName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddress() {
		return address;
	}

	public String getMainContact() {
		return mainContact;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMainContact(String mainContact) {
		this.mainContact = mainContact;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}