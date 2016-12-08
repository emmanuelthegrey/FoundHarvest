package com.team.treasure;

public class DAO_CompanyDonations {
	
	private CompanyProfile company;
	private Donation donation;
	

	public DAO_CompanyDonations(CompanyProfile company, Donation donation) {
		this.company = company;
		this.donation = donation;
	}

	public CompanyProfile getCompany() {
		return company;
	}

	public void setCompany(CompanyProfile company) {
		this.company = company;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	
	
}
	