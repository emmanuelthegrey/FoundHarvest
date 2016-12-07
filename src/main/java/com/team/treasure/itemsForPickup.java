package com.team.treasure;

public class itemsForPickup {
	
	private CompanyProfile company;
	private Donation donation;
	

	public itemsForPickup(CompanyProfile company, Donation donation) {
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
	