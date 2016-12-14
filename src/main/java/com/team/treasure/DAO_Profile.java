package com.team.treasure;

import java.util.List;

import javax.persistence.NoResultException;

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

		// encrypts password of passed in companyProfile
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encrypted = passwordEncryptor.encryptPassword(cp.getPassword());
		cp.setPassword(encrypted);

		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		// checks for company profiles with existing usernames

		Query query = hibernateSession.createQuery("from CompanyProfile where userName=?");
		CompanyProfile user = (CompanyProfile) query.setString(0, cp.getUserName()).uniqueResult();

		// if username already taken, closes transaction and retuns 0
		if (user != null) {
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return 0;
		} else {
			// else if username doesn't exist, adds the profile to the database,
			// and returns id
			int id = (Integer) hibernateSession.save(cp);
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return id;
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
		// Returns a company proflie object where the username equals the passed
		// in username
		Query<CompanyProfile> sql = hibernateSession.createQuery("FROM CompanyProfile WHERE userName=:userName",
				CompanyProfile.class);

		// sets the '=:userName' parameter, to the passed in parameter
		sql.setParameter("userName", userName);

		// initializes a null companyProfile object
		CompanyProfile companyProfile = null;
		try {
			// sets companyProfile and returns single object based on sql query
			// above
			companyProfile = sql.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}

		// make sure we can close the session
		try {
			// hibernateSession.getTransaction().commit();
			hibernateSession.close();
		} catch (Exception e) {
			System.out.println("DEBUG: Error caught: " + e);
		}

		// System.out.println(companyProfile.getCompanyName());

		// makes non decryptable passwordEncryptor object
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

		// checks if the given password is equal to the hashed password of the
		// company
		if (passwordEncryptor.checkPassword(password, companyProfile.getPassword())) {
			// System.out.println("DEBUG: Password passed");
			return companyProfile;
		} else {
			// System.out.println("DEBUG: Password failed against encrypted");
			return null;
		}
	}

	public static CompanyProfile getCompanyProfileById(int idCompanyProfile) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		CompanyProfile companyProfile = (hibernateSession.get(CompanyProfile.class, idCompanyProfile));
		hibernateSession.getTransaction().begin();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return companyProfile;
	}

	public static void updateCompanyProfile(CompanyProfile cp) {

		// encrypts password of passed in companyProfile
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encrypted = passwordEncryptor.encryptPassword(cp.getPassword());
		cp.setPassword(encrypted);
		
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		hibernateSession.update(cp);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		}

}
