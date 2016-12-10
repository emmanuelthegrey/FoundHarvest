package com.team.treasure;



	import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;

	public class DAO_Donation {
		private static SessionFactory factory;

		private static void setupFactory() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				;
			}

			Configuration configuration = new Configuration();
			// modify these to match your XML files
			configuration.configure("hibernate.cfg.xml");
			configuration.addResource("donation.hbm.xml");
			configuration.addResource("companyprofile.hbm.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}

		
		 public static int addDonation(Donation b) {
			if (factory == null)
				setupFactory();
			Session hibernateSession = factory.openSession();
			hibernateSession.getTransaction().begin();
			// save this specific record
			int i = (Integer) hibernateSession.save(b);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return i;
		} 
		 
		 public static Donation deleteDonation(int idcompanydonation) {
			 if (factory == null)
				 setupFactory();
			Session hibernateSession = factory.openSession();
			Donation deletedDonation = (hibernateSession.get(Donation.class, idcompanydonation));
			hibernateSession.getTransaction().begin();
			hibernateSession.delete(deletedDonation);
		    hibernateSession.getTransaction().commit();
		    hibernateSession.close();
		    return deletedDonation;
		    }
		

		public static List<itemsForPickup> getAllItemsForPickup() {
			if (factory == null)
				setupFactory();
			Session hibernateSession = factory.openSession();
			hibernateSession.getTransaction().begin();
			ArrayList<itemsForPickup> items = new ArrayList<itemsForPickup>();
			List<Donation> donations = hibernateSession.createQuery("FROM Donation order by expirationDate ASC").list();
				for (Donation d : donations) {
					CompanyProfile company = hibernateSession.get(CompanyProfile.class, d.getCompanyID());
					items.add(new itemsForPickup(company, d));
				}
				
			hibernateSession.getTransaction().commit();
			hibernateSession.close();

			return items;
		}
		
		public static List<Donation> getAllDonations() {
            if (factory == null)
                setupFactory();
            Session hibernateSession = factory.openSession();
            hibernateSession.getTransaction().begin();

            List<Donation> donations = hibernateSession.createQuery("FROM Donation").list();

            hibernateSession.getTransaction().commit();
            hibernateSession.close();

            return donations;
		}
		
		public static void confirmDonation(int id){
			if (factory == null)
                setupFactory();
            Session hibernateSession = factory.openSession();
            hibernateSession.getTransaction().begin();
			Donation donation = (hibernateSession.get(Donation.class, id));
			Date confirmationDate = Calendar.getInstance().getTime();
			donation.setStatus("complete");
			donation.setConfirmationDate(confirmationDate);
			hibernateSession.update(donation);
            //hibernateSession.createQuery("UPDATE Donation set status = complete"
            		//+ " where idCompanyDonation = :id").list();

            hibernateSession.getTransaction().commit();
            hibernateSession.close();

            
		}
		
		public static void cancelDonation(int id){
			if (factory == null)
                setupFactory();
            Session hibernateSession = factory.openSession();
            hibernateSession.getTransaction().begin();
			Donation donation = (hibernateSession.get(Donation.class, id));
			donation.setStatus("cancelled");
			hibernateSession.update(donation);
            //hibernateSession.createQuery("UPDATE Donation set status = complete"
            		//+ " where idCompanyDonation = :id").list();

            hibernateSession.getTransaction().commit();
            hibernateSession.close();
		}
		
	}
		/*
		public static List<itemsForPickup> getItemsForPickup() {
			if (factory == null)
				setupFactory();
			Session hibernateSession = factory.openSession();
			hibernateSession.getTransaction().begin();
			
			List<itemsForPickup> itemsForPickup = hibernateSession.createQuery("SELECT * from Donation inner join "
					+ "CompanyProfile ON companydonation.companyID =  " 
					

		}
		*/
	