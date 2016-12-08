package com.team.treasure;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		CompanyProfile user = DAO_Profile.checkLogin(username, password);
		
		if ((user != null) && user.getUserName().equalsIgnoreCase("admin")){
			Cookie adminID = new Cookie("admin", "" + user.getCompanyID());
			response.addCookie(adminID);
			
			// get the list of books from the dao
			List<itemsForPickup> items = DAO_Donation.getAllItemsForPickup();
			//List<CompanyProfile> companies = DAO_Profile.getAllProfiles();
			
			
			
			for (int i = 0; i < items.size(); i++) {
		
				if ((!items.get(i).getDonation().getStatus().equalsIgnoreCase("ready")) ||
					(items.get(i).getDonation().getExpirationDate() > 2)) {
					items.remove(i);
				}
			}
			
			// add this list to model
			model.addAttribute("itemList", items);	
			return "adminHome";
		}
		
		if (user != null) {
			model.addAttribute("user", user);
			Cookie userCompanyID = new Cookie("userCompanyID", "" + user.getCompanyID());
			response.addCookie(userCompanyID);
			return "donationform";
		}
		
		return "error";
	}

	@RequestMapping(value = "/DonationList", method = RequestMethod.GET)
	public String DonationList(Model model) {
		List<Donation> donations = DAO_Donation.getAllDonations();

		// add this list to model
		model.addAttribute("DonationList", donations);

		return "DonationList";
	}

	@RequestMapping(value = "/submittedDonation", method = RequestMethod.POST)
	public String submittedDonation(Model model, HttpServletRequest request) {
		//System.out.println(request.getQueryString());
		
		Donation donation = new Donation();
	
		donation.setProductDescription(request.getParameter("productDescription"));
		donation.setExpirationDate(Integer.parseInt(request.getParameter("expirationDate")));
		donation.setStatus("ready");
		Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("userCompanyID")) {
				donation.setCompanyID(Integer.parseInt(c.getValue()));
			}
		}
		
		DAO_Donation.addDonation(donation);
		
		
		model.addAttribute("productDescription", request.getParameter("productDescription"));
		//model.addAttribute("address", request.getParameter("address"));
		//model.addAttribute("publisher", request.getParameter("publisher"));
		//model.addAttribute("sales", request.getParameter("sales"));
		return "submittedDonation";
	}

	@RequestMapping(value = "/deletedDonation", method = RequestMethod.GET)
	public String deletedDonation(Model model, HttpServletRequest request) {

		// THIS ALSO DELETES THE donation
		Donation deletedDonation = DAO_Donation
				.deleteDonation(Integer.parseInt(request.getParameter("donationidCompanyDonation")));
		// DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
		// <!-- <td><a href="<c:url value='/delete/${book[status.index].rank}'
		// />" >Delete</a></td> -->
		// model.addAttribute("nameOfCompany",
		// deletedDonation.getNameOfCompany());
		// model.addAttribute("address", deletedDonation.getAddress());
		// model.addAttribute("publisher", deletedBook.getPublisher());
		// model.addAttribute("sales", deletedBook.getSales());

		return "deletedDonation";
	}

	@RequestMapping(value = "/submittedRegistration", method = RequestMethod.POST)
	public String submittedRegistration(Model model, HttpServletRequest request, HttpServletResponse response) {
		// System.out.println(request.getQueryString());

		CompanyProfile cp = new CompanyProfile();

		cp.setCompanyName(request.getParameter("companyName"));
		cp.setAddress(request.getParameter("address"));
		cp.setMainContact(request.getParameter("contact"));
		cp.setCompanyPhoneNumber(request.getParameter("phoneNumber"));
		cp.setEmail(request.getParameter("email"));
		cp.setTwitterName(request.getParameter("twitter"));
		cp.setUserName(request.getParameter("username"));
		cp.setPassword(request.getParameter("password"));

		int id = DAO_Profile.addCompanyProfile(cp);
		/*
		 * Cookie userID = new Cookie("userid", "" + id); Cookie companyName =
		 * new Cookie("companyName", request.getParameter("companyName"));
		 * Cookie address = new Cookie("userid",
		 * request.getParameter("address")); Cookie mainContact = new
		 * Cookie("userid", request.getParameter("contact")); Cookie
		 * companyPhoneNumber = new Cookie("userid",
		 * request.getParameter("phoneNumber"));
		 * 
		 * response.addCookie(userID); response.addCookie(companyName);
		 * response.addCookie(address); response.addCookie(mainContact);
		 * response.addCookie(companyPhoneNumber);
		 */
		// donation.setPublisher(request.getParameter("publisher"));
		// donation.setSales(Integer.parseInt(request.getParameter("sales")));

		model.addAttribute("companyName", request.getParameter("companyName"));
		model.addAttribute("address", request.getParameter("address"));
		// model.addAttribute("publisher", request.getParameter("publisher"));
		// model.addAttribute("sales", request.getParameter("sales"));
		return "submittedRegistration";
	}

	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(Model model, HttpServletRequest request) {
		/*
		String validateAdmin = "adminID";
		Cookie[] cookies = request.getCookies();
		String adminCookie = "";
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("adminID")) {
				adminCookie = c.getName();
			}
		}
		
		if (validateAdmin.equalsIgnoreCase(adminCookie)) { */
		// get the list of books from the dao
		List<itemsForPickup> items = DAO_Donation.getAllItemsForPickup();
		//List<CompanyProfile> companies = DAO_Profile.getAllProfiles();
		
		
		
		
		for (int i = 0; i < items.size(); i++) {
			if ((!items.get(i).getDonation().getStatus().equalsIgnoreCase("ready")) ||
				(items.get(i).getDonation().getExpirationDate() > 2)) {
				items.remove(i);
			}
		}
		
		// add this list to model
		model.addAttribute("itemList", items);

		return "adminHome";
		/*}
		else {
			return "error";
		} */
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		return "login";
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(Model model, HttpServletRequest request) throws TwitterException {
		DAO_Donation.confirmDonation(Integer.parseInt(request.getParameter("confirm")));
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    
	    
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey("zbRmQD45ctlOxf1GS048INBrZ")
	    .setOAuthConsumerSecret("MzLgQBVdnbJ74Ij2opA0CTV9k9z8wpZ0f8EvhfFQGgB2bFU56g")
	    .setOAuthAccessToken("805785792778006528-fZ9kuMOyGEWAM8XhNYHQ4y9ymshuMTG")
	    .setOAuthAccessTokenSecret("ZYYovl5YdK6Z3wH9364TxbM8Evr2QR77WhpnbwvAIbR4f");
	    
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    
	    String tweetName = request.getParameter("tweet");
	    
	    twitter4j.Twitter tw = tf.getInstance();
	    
	    Status stat = tw.updateStatus("Thank you @" + tweetName + " !");
	    System.out.println("Twitter updated");

		return "confirm";
	}
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(Model model, HttpServletRequest request) {
		DAO_Donation.cancelDonation(Integer.parseInt(request.getParameter("cancel")));
		
		
		return "cancel";
	}
	
	
	
}