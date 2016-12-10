package com.team.treasure;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.jasypt.util.password.StrongPasswordEncryptor;

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

	public static int addCompanyProfile(CompanyProfile cp) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encrypted = passwordEncryptor.encryptPassword(cp.getPassword());
		cp.setPassword(encrypted);

		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		Query query=  hibernateSession.createQuery("from CompanyProfile where userName=?");

		CompanyProfile user=(CompanyProfile)query.setString(0,cp.getUserName()).uniqueResult();
		if(user!=null){
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return 0;
		}else{
			//Insert user
			// save this specific record
			int i = (Integer) hibernateSession.save(cp);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return i;
		} 
		
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
		List<CompanyProfile> profile = hibernateSession.createQuery("FROM CompanyProfile").list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();

		return profile;
	}

	public static CompanyProfile checkLogin(String userName, String password) {
		// System.out.println("DEBUG: check password=" + password);

		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();

		// prepared statement to protect against injection
		Query<CompanyProfile> sql = hibernateSession.createQuery("FROM CompanyProfile WHERE userName=:userName", CompanyProfile.class);
		sql.setParameter("userName", userName);
		CompanyProfile companyProfile = sql.getSingleResult();

		try {
			// hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch (Exception e) {
			System.out.println("DEBUG: Error caught: " + e);
		}
		
		//System.out.println(companyProfile.getCompanyName());
		
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		if (passwordEncryptor.checkPassword(password, companyProfile.getPassword())) {
			// System.out.println("DEBUG: Password passed");
			return companyProfile;
		} else {
			// System.out.println("DEBUG: Password failed against encrypted");
			return null;
		}
	}

}
