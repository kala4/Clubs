package by.clubs.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

/**
 * @author Kalachev
 *
 */
public class HibernateJpaUtil {
	private static final Logger LOG = Logger.getLogger(HibernateJpaUtil.class);
	private static EntityManagerFactory entityManagerFactory;

	static {
		try {
			// like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
			// 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
			entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
		} catch (Throwable ex) {
			LOG.error("Exception while creating EntityManagerFactory: "+ex.getMessage(), ex);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}