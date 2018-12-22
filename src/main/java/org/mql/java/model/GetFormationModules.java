package org.mql.java.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mql.java.entities.Formation;
import org.mql.java.entities.Module;
import org.mql.java.entities.Timing;

public class GetFormationModules {

	

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.configure().addAnnotatedClass(Formation.class)
							.addAnnotatedClass(Module.class)
							.addAnnotatedClass(Timing.class)
							.buildSessionFactory();
			
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int id = 1;
			Formation formation;
			formation = session.get(Formation.class, id);
			session.getTransaction().commit();
			System.out.println("done....! ");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
