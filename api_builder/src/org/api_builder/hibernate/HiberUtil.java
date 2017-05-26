package org.api_builder.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class HiberUtil {
	public static Session getSession() throws HibernateException {
		return HibernateSessionFactory.getInstance().openSession();
	}

	public static void closeSession() throws HibernateException {
		HibernateSessionFactory.getInstance().close();
	}
}
