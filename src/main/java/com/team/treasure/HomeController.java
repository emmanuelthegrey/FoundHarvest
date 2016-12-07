package com.team.treasure;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.jasypt.util.password.StrongPasswordEncryptor;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/DonationList", method = RequestMethod.GET)
	public String DonationList(Model model) {
		List<Donation> donations = DAO_Donation.getAllDonations();
		
		//add this list to model
		model.addAttribute("DonationList", donations);
		
		return "DonationList";
	}
	
	@RequestMapping(value = "/submittedDonation", method = RequestMethod.POST)
	public String submittedDonation(Model model, HttpServletRequest request) {
		//System.out.println(request.getQueryString());
		Donation donation = new Donation();
		donation.setNameOfCompany(request.getParameter("nameOfCompany"));
		donation.setAddress(request.getParameter("address"));
		donation.setProductDescription(request.getParameter("productDescription"));
		donation.setItemQuantity(Integer.parseInt(request.getParameter("itemQuantity")));
		donation.setExpirationDate(Integer.parseInt(request.getParameter("expirationDate")));
		donation.setStatus(request.getParameter("status"));
				
		//donation.setSales(Integer.parseInt(request.getParameter("sales")));
		
		DAO_Donation.addDonation(donation);
		
		model.addAttribute("companyName", request.getParameter("companyName"));
		model.addAttribute("address", request.getParameter("address"));
		//model.addAttribute("publisher", request.getParameter("publisher"));
		//model.addAttribute("sales", request.getParameter("sales"));
		return "submittedDonation";
	}
	
	@RequestMapping(value = "/deletedDonation", method= RequestMethod.GET)
	public String deletedDonation(Model model, HttpServletRequest request) {
		
		//THIS ALSO DELETES THE BOOK
		Donation deletedDonation = DAO_Donation.deleteDonation(Integer.parseInt(request.getParameter("donationidCompanyDonation")));
		//DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
		//<!--   <td><a href="<c:url value='/delete/${book[status.index].rank}' />" >Delete</a></td> -->
		model.addAttribute("nameOfCompany", deletedDonation.getNameOfCompany());
		model.addAttribute("address", deletedDonation.getAddress());
		//model.addAttribute("publisher", deletedBook.getPublisher());
		//model.addAttribute("sales", deletedBook.getSales());
		
		return "deletedDonation";
	}
	
	@RequestMapping(value = "/submittedRegistration", method = RequestMethod.POST)
	public String submittedRegistration(Model model, HttpServletRequest request) {
		//System.out.println(request.getQueryString());
		
		
		CompanyProfile cp = new CompanyProfile();
		
		cp.setCompanyName(request.getParameter("companyName"));
		cp.setAddress(request.getParameter("address"));
		cp.setMainContact(request.getParameter("contact"));
		cp.setCompanyPhoneNumber(request.getParameter("phoneNumber"));
		cp.setEmail(request.getParameter("email"));
		cp.setTwitterName(request.getParameter("twitter"));
		cp.setUserName(request.getParameter("username"));
		cp.setPassword(request.getParameter("password"));
		
		
		DAO_Profile.addCompanyProfile(cp);
		
		
		
		//donation.setPublisher(request.getParameter("publisher"));
		//donation.setSales(Integer.parseInt(request.getParameter("sales")));
		
		
		model.addAttribute("companyName", request.getParameter("companyName"));
		model.addAttribute("address", request.getParameter("address"));
		//model.addAttribute("publisher", request.getParameter("publisher"));
		//model.addAttribute("sales", request.getParameter("sales"));
		return "submittedRegistration";
	}
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(Model model) {
		//get the list of books from the dao
		List<Donation> donations = DAO_Donation.getAllDonations();
		
		//add this list to model
		model.addAttribute("adminList", donations);
		
		return "adminHome";
	}
	
	/*
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request) {
        
        DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
        model.addAttribute("rank", Integer.parseInt(request.getParameter("rank")));
        return "delete";
    }
	*/
	
}