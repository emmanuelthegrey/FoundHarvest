package com.team.treasure;



	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;

	public class DAO_Profile {
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
			configuration.addResource("companyprofile.hbm.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}

		
		 public static int addCompanyProfile(CompanyProfile b) {
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
		 
		 public static CompanyProfile deleteCompanyProfile(int idCompanyProfile) {
			 if (factory == null)
				 setupFactory();
			Session hibernateSession = factory.openSession();
			CompanyProfile deletedCompanyProfile = (hibernateSession.get(CompanyProfile.class, idCompanyProfile));
			hibernateSession.getTransaction().begin();
			hibernateSession.delete(deletedCompanyProfile);
		    hibernateSession.getTransaction().commit();
		    hibernateSession.close();
		    return deletedCompanyProfile;
		    }
		

		public static List<CompanyProfile> getAllProfiles() {
			if (factory == null)
				setupFactory();
			Session hibernateSession = factory.openSession();
			hibernateSession.getTransaction().begin();
			List<CompanyProfile> profile = hibernateSession.createQuery("FROM companyProfile").list();
			hibernateSession.getTransaction().commit();
			hibernateSession.close();

			return profile;
		}
	}
