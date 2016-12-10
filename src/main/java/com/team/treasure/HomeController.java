package com.team.treasure;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		CompanyProfile user = DAO_Profile.checkLogin(username, password);



		if ((user != null) && user.getUserName().equalsIgnoreCase("admin")){
			Cookie adminID = new Cookie("admin", "" + user.getCompanyID());
			response.addCookie(adminID);
			
			List<itemsForPickup> items = DAO_Donation.getAllItemsForPickup();
			
			Iterator<itemsForPickup> iter = items.iterator();
			
	        while (iter.hasNext()) {
	        	itemsForPickup tempItem = iter.next();
	        	Date itemDate = tempItem.getDonation().getExpirationDate();
				if (!(tempItem.getDonation().getStatus().equalsIgnoreCase("ready")) || 
					(itemDate.before(Calendar.getInstance().getTime()))) {
						 iter.remove();
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
		if (user == null) {
			return "error";
		}
		return "";
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
		// System.out.println(request.getQueryString());

		Donation donation = new Donation();

		
		//adds days until expiration and makes it a local date object
		LocalDate expirationLocalDate = LocalDate.now().plusDays(Integer.parseInt(request.getParameter("expirationDate")));
		
		//turns localdate into date
		Date date = Date.from(expirationLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		donation.setExpirationDate(date);

		Date expirationDate = Date.from(expirationLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		//sets date of submission to current day
		Date submissionDate = Calendar.getInstance().getTime();
		
		
		donation.setSubmissionDate(submissionDate);
		donation.setExpirationDate(expirationDate);
		donation.setProductDescription(request.getParameter("productDescription"));
		donation.setWeight(Integer.parseInt(request.getParameter("enterWeight")));

		donation.setStatus("ready");
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("userCompanyID")) {
				donation.setCompanyID(Integer.parseInt(c.getValue()));
			}
		}

		DAO_Donation.addDonation(donation);

		model.addAttribute("productDescription", request.getParameter("productDescription"));
		// model.addAttribute("address", request.getParameter("address"));
		// model.addAttribute("publisher", request.getParameter("publisher"));
		// model.addAttribute("sales", request.getParameter("sales"));
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
		System.out.println("id is: " + id);
		if (id == 0 ) {
			model.addAttribute("username", request.getParameter("username"));
			return "registrationTaken";
		}
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
		
		model.addAttribute("companyName", request.getParameter("companyName"));
	
		return "submittedRegistration";
	}

	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(Model model, HttpServletRequest request) throws UnsupportedOperationException {
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
		
		Iterator<itemsForPickup> iter = items.iterator();
		
        while (iter.hasNext()) {
        	itemsForPickup tempItem = iter.next();
        	Date itemDate = tempItem.getDonation().getExpirationDate();
        	//LocalDate localExpirationDate = itemDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (!(tempItem.getDonation().getStatus().equalsIgnoreCase("ready")) || 
				((itemDate.before(Calendar.getInstance().getTime())))) {
					 iter.remove();
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
	    .setOAuthConsumerKey(Props.KEY)
	    .setOAuthConsumerSecret(Props.Secret)
        .setOAuthAccessToken(Props.Token)
	    .setOAuthAccessTokenSecret(Props.TokenSecret);
	    
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    twitter4j.Twitter tw = tf.getInstance();
	    
	    String tweetName = request.getParameter("tweet");
	    String companyName = request.getParameter("companyName");
	    String productDescription = request.getParameter("productDescription");
	   
	 
	    if(tweetName.equalsIgnoreCase("")){
	    	Status stat = tw.updateStatus("Thank you @" + companyName + " for the " + productDescription + "!");
		    System.out.println("tweetname is null");
	    }else{
	    Status stat = tw.updateStatus("Thank you @" + tweetName + " for " + productDescription +"!");
	    //System.out.println("Twitter updated");
	    }

		return "confirm";
	}


	@RequestMapping(value = "/CompanyDonations", method = RequestMethod.GET)
	public String CompanyDonations(Model model, HttpServletRequest request) {
		
		List<itemsForPickup> items = DAO_Donation.getAllItemsForPickup();

		int companyID = 0;
		
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("userCompanyID")) {
				companyID = (Integer.parseInt(c.getValue()));
				//System.out.println(companyID);
			}
		}
		
		Iterator<itemsForPickup> iter = items.iterator();
	        while (iter.hasNext()) {
			if (iter.next().getDonation().getCompanyID() != companyID) {
				//System.out.println("items company id that should be removed: " + (items.get(i).getDonation().getCompanyID()));
				iter.remove();
			}
		}
	    model.addAttribute("companyName", items.get(0).getCompany().getCompanyName());    
		model.addAttribute("itemList", items);

		return "CompanyDonations";
	}

	@RequestMapping(value = "/adminHomeQueue", method = RequestMethod.GET)
	public String adminHomeQueue(Model model, HttpServletRequest request) {
		//referencing ItemsForPickup object to build table
		List<itemsForPickup> items = DAO_Donation.getAllItemsForPickup();
		
		Iterator<itemsForPickup> iter = items.iterator();
        while (iter.hasNext()) {
			if (!(iter.next().getDonation().getStatus().equalsIgnoreCase("complete"))) {
					 iter.remove();
			}
		}

		model.addAttribute("itemList", items);

		return "adminHomeQueue";
	}

	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public String cancel(Model model, HttpServletRequest request) {
		DAO_Donation.cancelDonation(Integer.parseInt(request.getParameter("cancel")));
		
		
		return "cancel";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(Model model, HttpServletRequest request) {

		return "error";
	}
	
	@RequestMapping(value = "/donationform", method = {RequestMethod.GET, RequestMethod.POST})
	public String donationForm(Model model, HttpServletRequest request) {

		return "donationform";
	}
	

}