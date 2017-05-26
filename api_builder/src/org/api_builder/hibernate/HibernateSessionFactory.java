package org.api_builder.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	
	private HibernateSessionFactory(){}
	
	public static SessionFactory getInstance(){
		if(factory == null){
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			try {
				factory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				System.out.println("Error : " + e.getMessage());
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy( registry );
			}
		}
		return factory;
	}
}
