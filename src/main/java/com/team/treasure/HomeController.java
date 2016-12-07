package com.team.treasure;

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		CompanyProfile user = DAO_Profile.checkLogin(username, password);
		
		if (user != null) {
		model.addAttribute("user", user);
		Cookie userCompanyID = new Cookie("userCompanyID", "" + user.getCompanyID());
		response.addCookie(userCompanyID);
		}
		return "home";
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
		//donation.setNameOfCompany(request.getParameter("nameOfCompany"));
		//donation.setAddress(request.getParameter("address"));
		//donation.setItemQuantity(Integer.parseInt(request.getParameter("itemQuantity")));
		donation.setProductDescription(request.getParameter("productDescription"));
		donation.setExpirationDate(Integer.parseInt(request.getParameter("expirationDate")));
		donation.setStatus(request.getParameter("status"));
		Cookie[] cookies = request.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("userCompanyID")) {
				donation.setCompanyID(Integer.parseInt(c.getName()));
			}
		}
		
		DAO_Donation.addDonation(donation);
		
		
		model.addAttribute("companyName", request.getParameter("companyName"));
		model.addAttribute("address", request.getParameter("address"));
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
		// get the list of books from the dao
		List<Donation> donations = DAO_Donation.getAllDonations();

		// add this list to model
		model.addAttribute("adminList", donations);

		/*
		 * Cookie[] cookies = request.getCookies();
		 * 
		 * for (Cookie c : cookies) { if
		 * (c.getName().equalsIgnoreCase("companyName")) {
		 * model.addAttribute("companyName", c.getName()); } if
		 * (c.getName().equalsIgnoreCase("address")) {
		 * model.addAttribute("address", c.getName()); } if
		 * (c.getName().equalsIgnoreCase("mainContact")) {
		 * model.addAttribute("mainContact", c.getName()); } if
		 * (c.getName().equalsIgnoreCase("companyPhoneNumber")) {
		 * model.addAttribute("companyPhoneNumber", c.getName()); }
		 * 
		 * }
		 */

		return "adminHome";
	}

	/*
	 * @RequestMapping(value = "/delete", method = RequestMethod.GET) public
	 * String delete(Model model, HttpServletRequest request) {
	 * 
	 * DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
	 * model.addAttribute("rank",
	 * Integer.parseInt(request.getParameter("rank"))); return "delete"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		return "login";
	}

}